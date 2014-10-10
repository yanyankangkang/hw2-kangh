/**
 * extract gene-related phrases or words
 */
package annotator;

import java.io.IOException;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import type.Lingpipe;
import type.Sentence;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

import java.util.Iterator;

/**
 * Filter out gene-related words using Confidence Named Entity Chunking of LingPipe
 * 
 * @author Kang Huang
 * @version 1.0 Build on Sep 23, 2014.
 *
 */
public class LingPipe extends JCasAnnotator_ImplBase {
  /**
   * the maximum length of potential gene words
   */
  private static final int _MAX_N_BEST_CHUNKS = 10;

  /**
   * the handler to load the model and process given words
   */
  private ConfidenceChunker _chunker = null;

  private static double _CONFIDENCE = 0.05;

  @Override
  /** 
   *<p>The framework supplies this AnalysisComponent with a reference to the UimaContext that it will use,<br>
   * for example to access configuration settings or resources. This AnalysisComponent should store a <br>
   * reference to its the UimaContext for later use.<br>
   * 
   * @param context
   *          Provides access to external resources (other than the CAS).Performs any startup tasks required by this component. The framework calls this method only once, just 
   * after the AnalysisComponent has been instantiated. 
   * 
   * @throws ClassNotFoundException    Description of ClassNotFoundException found no such model
   * @throws IOException Description of  IOException fail to visit model
   * 
   * @return 
   */
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);

    try {
      _chunker = (ConfidenceChunker) AbstractExternalizable.readResourceObject(LingPipe.class,
              (String) context.getConfigParameterValue("GeneTagModel"));
      // chunker = (ConfidenceChunker) AbstractExternalizable.readResourceObject("/neenbiogenetag");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  /**
   *  get content of annotation sentence and use NER gene model to classify the sentence in each annotation, 
   *  obtain start index and end index of filtered words and
   *  revise by subtracting the number of blanks. the gene annotation also stored the ID and words. 
   * 
   * @param aCas 
   *          A JCas object provides the starting point for working with the CAS using Java Cover Classes for each  type, generated by the utility JCasGen. 
   *
   * @throws ClassNotFoundException   
   *           Description of ClassNotFoundException found no such model
   * @throws IOException 
   *            Description of IOException fail to visit model
   */
  public synchronized void process(JCas aCas) throws AnalysisEngineProcessException {
    FSIterator<Annotation> it = aCas.getAnnotationIndex(Sentence.type).iterator();
    // while (it.hasNext()) {
    Sentence annot = (Sentence) it.next();
    String temp = annot.getWords();
    char[] cs = temp.toCharArray();
    Iterator<Chunk> gene_it = _chunker.nBestChunks(cs, 0, cs.length, _MAX_N_BEST_CHUNKS);
    while (gene_it.hasNext()) {
      Chunk chunk = gene_it.next();
      double conf = Math.pow(2.0, chunk.score());
      if (conf > _CONFIDENCE) {
        int start = chunk.start();
        int end = chunk.end();
        String phrase = temp.substring(start, end);
        Lingpipe gene = new Lingpipe(aCas);
        gene.setBegin(start);
        gene.setEnd(end);
        gene.setID(annot.getID());
        gene.setWords(phrase);
        gene.setCasProcessorId("LingPipe");
        gene.setConfidence(conf);
        gene.addToIndexes(aCas);
      }
    }
  }
}