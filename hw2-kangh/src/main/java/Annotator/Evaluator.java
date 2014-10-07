package Annotator;

import java.io.IOException;
import java.util.HashMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import Type.Answer;
import Type.Lingpipe;
import Type.Abner;

public class Evaluator extends JCasAnnotator_ImplBase {
  private HashMap<String, Integer> abner_dict = new HashMap<String, Integer>();

  private static double CONFIDENCE = 0.6;
  private EntrezGeneDAO eg = null;
  public void initialize(JCas jcas) {
    FSIterator<Annotation> abner_it = jcas.getAnnotationIndex(Abner.type).iterator();
    while (abner_it.hasNext()) {
      Abner abner = (Abner) abner_it.next();
      abner_dict.put(abner.getWords(), 1);
    }
    eg = new EntrezGeneDAO();
    // System.out.println("Evaluator Initialization");
  }

  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    initialize(aJCas);
    FSIterator<Annotation> Lingpipe_it = aJCas.getAnnotationIndex(Lingpipe.type).iterator();
    while (Lingpipe_it.hasNext()) {
      Lingpipe Ling = (Lingpipe) Lingpipe_it.next();
      if (abner_dict.containsKey(Ling.getWords())){//|| eg.search(Ling.getWords())) {
        Answer answer = new Answer(aJCas);
     // System.out.println(Ling.getWords());
     //   if (Ling.getConfidence() > CONFIDENCE)
     //   answer.setCasProcessorId(Ling.getCasProcessorId());
        answer.setWords(Ling.getWords());
        answer.setID(Ling.getID());
        answer.setBegin(Ling.getBegin());
        answer.setEnd(Ling.getEnd());
        answer.addToIndexes(aJCas);
      }
    }
  }

}
