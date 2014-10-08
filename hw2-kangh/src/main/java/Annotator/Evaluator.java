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
  private HashMap<String, Lingpipe> ling_dict = new HashMap<String, Lingpipe>();
  private static double CONFIDENCE = 0.6;
  private double X[][] = new double [15000][2]; 
  private int N = 0;
  private EntrezGeneDAO eg = null;

  public void initialize(JCas jcas) {
   // FSIterator<Annotation> abner_it = jcas.getAnnotationIndex(Abner.type).iterator();
  /*  while (abner_it.hasNext()) {
      Abner abner = (Abner) abner_it.next();
      abner_dict.put(abner.getWords(), 0);
    }*/
    FSIterator<Annotation> Lingpipe_it = jcas.getAnnotationIndex(Lingpipe.type).iterator();
    while (Lingpipe_it.hasNext()) {
      Lingpipe Ling = (Lingpipe) Lingpipe_it.next();
      ling_dict.put(Ling.getWords(), Ling);
    }
   // eg = new EntrezGeneDAO();
   // System.out.println("Evaluator Initialization");
  }

  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    initialize(aJCas);
    

    //  FSIterator<Annotation> Lingpipe_it = aJCas.getAnnotationIndex(Lingpipe.type).iterator();
    FSIterator<Annotation> abner_it = aJCas.getAnnotationIndex(Abner.type).iterator();
    while (abner_it.hasNext()) {
      Abner abner = (Abner) abner_it.next();
      String word = abner.getWords();
      X[N][1] = 1;
      if (ling_dict.containsKey(word)) {// || eg.search(Ling.getWords())) {
        Answer answer = new Answer(aJCas);
        // System.out.println(Ling.getWords());
        // if (Ling.getConfidence() > CONFIDENCE)
        // answer.setCasProcessorId(Ling.getCasProcessorId());
        X[N][0] = ling_dict.get(word).getConfidence();
        ling_dict.remove(word);
       /* answer.setWords(Ling.getWords());
        answer.setID(Ling.getID());
        answer.setBegin(Ling.getBegin());
        answer.setEnd(Ling.getEnd());
        answer.addToIndexes(aJCas);*/
      }
      else{
        X[N][0] = 0;
      }
      N++;
    }
    for (String word : ling_dict.keySet()){
      X[N][0] = ling_dict.get(word).getConfidence();
      X[N][1] = 0;
      N++;
    }
  }

}
