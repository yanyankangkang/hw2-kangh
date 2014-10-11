package annotator;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import abner.Tagger;
import type.Abner;
import type.BaseAnnotation;

/**
 * 
 * @author Kang Huang
 * @version 1.0 Build on Oct 8, 2014. Abner is a NER tool which extracts protein, DNA, RNA,
 *          Cell_Type, Cell_Line based on NLPBA model
 *
 */
public class ABNER extends JCasAnnotator_ImplBase {
  /**
   * the handler calling function of abner
   */
  private Tagger mchunk = null;

  /**
   * the average performance of Abner based on statistic data on websites
   */
  private static double sABNER_CONFIDENCE = 0.7;

  /**
   * initialize abner hander
   */
  public void initialize(UimaContext context) throws ResourceInitializationException {
    mchunk = new Tagger();
    // System.out.println();
  }

  /**
   * Analyze sentence by sentence extracting all possible words with its relevant information and
   * stored in Abner annotation
   * 
   * @param aJCas
   *          Provides access to external resources (other than the CAS).Performs any startup tasks
   *          required by this component. The framework calls this method only once, just after the
   *          AnalysisComponent has been instantiated.
   * 
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    FSIterator<Annotation> it = aJCas.getAnnotationIndex(BaseAnnotation.type).iterator();
    // while (it.hasNext()) {
    BaseAnnotation annot = (BaseAnnotation) it.next();
    Abner abner = new Abner(aJCas);
    abner.setCasProcessorId("Abner");
    String ent[][] = mchunk.getEntities(annot.getWords());
    for (int i = 0; i < ent[0].length; i++) {
      // if (ent[1][i] == "RNA" && ent[1][i] == "DNA"){
      int start = annot.getWords().indexOf(ent[0][i]);
      int end = start + ent[0][i].length() - 1;
      /*
       * System.out.println(annot.getSentence()); System.out.println(ent[0][i]);
       * System.out.println(start + " " + end);
       */
      abner.setCasProcessorId("Abner");
      abner.setWords(ent[0][i]);
      abner.setTypes(ent[1][i]);
      abner.setConfidence(sABNER_CONFIDENCE);
      abner.setID(annot.getID());
      abner.setBegin(start);
      abner.setEnd(end);
      // abner.setBegin();
      // System.out.print(ent[0][i]);
      abner.addToIndexes(aJCas);
      // }
    }
    // System.out.println();
  }

}
