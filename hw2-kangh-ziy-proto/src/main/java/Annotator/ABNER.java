package Annotator;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import abner.Tagger;
import Type.Abner;
import Type.Sentence;

public class ABNER extends JCasAnnotator_ImplBase {
  private Tagger chunk = null;
  private static double ABNER_CONFIDENCE = 0.7;
  public void initialize(UimaContext context) throws ResourceInitializationException {
    chunk = new Tagger();
    // System.out.println();
  }

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    FSIterator<Annotation> it = aJCas.getAnnotationIndex(Sentence.type).iterator();
    // while (it.hasNext()) {
    Sentence annot = (Sentence) it.next();
    Abner abner = new Abner(aJCas);
    abner.setCasProcessorId("Abner");
    String ent[][] = chunk.getEntities(annot.getSentence());
    for (int i = 0; i < ent[0].length; i++) {
      // if (ent[1][i] == "RNA" && ent[1][i] == "DNA"){
      abner.setCasProcessorId("Abner");
      abner.setWords(ent[0][i]);
      abner.setTypes(ent[1][i]);
      abner.setConfidence(ABNER_CONFIDENCE);
      // System.out.print(ent[0][i]);
      abner.addToIndexes(aJCas);
      // }
    }
    // System.out.println();
  }

}
