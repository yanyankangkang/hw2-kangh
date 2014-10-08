package Annotator;

//import java.io.IOException;
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
 // private HashMap<String, Integer> abner_dict = new HashMap<String, Integer>();

  private HashMap<String, Lingpipe> ling_dict = new HashMap<String, Lingpipe>();

  // private EntrezGeneDAO eg = null;

  private double Theta[] = { -150.61294935586648, 203.0498649014589, 149.92000292839552 };

  private Logisitic Model;

  public void initialize(JCas jcas) {
    // FSIterator<Annotation> abner_it = jcas.getAnnotationIndex(Abner.type).iterator();
    /*
     * while (abner_it.hasNext()) { Abner abner = (Abner) abner_it.next();
     * abner_dict.put(abner.getWords(), 0); }
     */
    FSIterator<Annotation> Lingpipe_it = jcas.getAnnotationIndex(Lingpipe.type).iterator();
    while (Lingpipe_it.hasNext()) {
      Lingpipe Ling = (Lingpipe) Lingpipe_it.next();
      ling_dict.put(Ling.getWords(), Ling);
    }
    Model = new Logisitic(2);
    // eg = new EntrezGeneDAO();
    // System.out.println("Evaluator Initialization");
  }

  private void addToCas(Answer answer, Lingpipe Ling) {
    answer.setWords(Ling.getWords());
    answer.setID(Ling.getID());
    answer.setBegin(Ling.getBegin());
    answer.setEnd(Ling.getEnd());
    answer.addToIndexes();
  }

  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    initialize(aJCas);

    // FSIterator<Annotation> Lingpipe_it = aJCas.getAnnotationIndex(Lingpipe.type).iterator();
    FSIterator<Annotation> abner_it = aJCas.getAnnotationIndex(Abner.type).iterator();
    double x[] = new double[2];
    while (abner_it.hasNext()) {
      Abner abner = (Abner) abner_it.next();
      String word = abner.getWords();
      x[1] = abner.getConfidence();
      Lingpipe Ling = ling_dict.get(word);
      if (ling_dict.containsKey(word)) {
        x[0] = Ling.getConfidence();
        ling_dict.remove(word);
      } else {
        x[0] = 0;
      }
      if (Model.Classify(x, Theta)) {
        Answer answer = new Answer(aJCas);
        addToCas(answer, Ling);
      }
    }

    for (String word : ling_dict.keySet()) {
      Lingpipe Ling = ling_dict.get(word);
      // System.out.println(Ling.getConfidence());
      x[0] = Ling.getConfidence();
      x[1] = 0;

      if (Model.Classify(x, Theta)) {
        Answer answer = new Answer(aJCas);
        addToCas(answer, Ling);
      }
    }
    ling_dict.clear();
  }
}
