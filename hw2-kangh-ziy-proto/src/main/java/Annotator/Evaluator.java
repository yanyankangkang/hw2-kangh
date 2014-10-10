package Annotator;

import java.util.HashMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import Type.Answer;
import Type.Lingpipe;
import Type.Abner;
import Type.BaseAnnotation;
import Type.Sentence;

/**
 * 
 * @author Kang Huang
 * @version 1.0 Build on Oct 8, 2014. Merge the results from LingPipe and Abner, use the confidence
 *          of each result as features
 */
public class Evaluator extends JCasAnnotator_ImplBase {
  // private HashMap<String, Integer> abner_dict = new HashMap<String, Integer>();

  private HashMap<String, Lingpipe> ling_dict = new HashMap<String, Lingpipe>();

  // private EntrezGeneDAO eg = null;
  /**
   * this parameter is generated by another CPE procedure
   */
  private double Theta[] = { -9.009515604622354, 14.819006159685497, 8.36333671635934 };

  /**
   * Logistic Model contains classify function
   */
  private Logisitic Model;

  /**
   * Initialize logistic model by assigning the number of feature and build temporary dictionary of
   * result from Abner
   * 
   * @param jcas
   */
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

  /*
   * private void addToCas(Answer answer, Lingpipe Ling) { answer.setWords(Ling.getWords());
   * answer.setID(Ling.getID()); answer.setBegin(Ling.getBegin()); answer.setEnd(Ling.getEnd());
   * answer.addToIndexes(); }
   */

  /**
   * We use the logistic regression to merge the result from Abner and LingPipe respectively
   */
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    initialize(aJCas);
    // FSIterator<Annotation> Lingpipe_it = aJCas.getAnnotationIndex(Lingpipe.type).iterator();
    FSIterator<Annotation> abner_it = aJCas.getAnnotationIndex(Abner.type).iterator();
    FSIterator<Annotation> line_it = aJCas.getAnnotationIndex(Sentence.type).iterator();
    Sentence Line = (Sentence) line_it.next();
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
        // addToCas(answer, Abner);
        answer.setWords(abner.getWords());
        answer.setID(abner.getID());
        answer.setBegin(abner.getBegin());
        answer.setEnd(abner.getEnd());
        answer.setCasProcessorId(abner.getCasProcessorId());
        answer.addToIndexes();
      }
    }

    for (String word : ling_dict.keySet()) {
      Lingpipe Ling = ling_dict.get(word);
      // System.out.println(Ling.getConfidence());
      x[0] = Ling.getConfidence();
      x[1] = 0;

      if (Model.Classify(x, Theta)) {
        Answer answer = new Answer(aJCas);
        // addToCas(answer, Ling);
        /*
         * System.out.println("**************"); System.out.println(Line.getWords() + " " +
         * Line.getWords().length()); System.out.println(Ling.getWords() + " " + Ling.getBegin() +
         * " " +Ling.getEnd());
         */
        int outershift = countBlanks(Line.getWords(), 0, Ling.getBegin());
        int innershift = countBlanks(Line.getWords(), Ling.getBegin(), Ling.getEnd());

        answer.setWords(Ling.getWords());
        answer.setID(Ling.getID());
        answer.setBegin(Ling.getBegin() - outershift);
        answer.setEnd(Ling.getEnd() - outershift - innershift - 1);
        answer.setCasProcessorId(Ling.getCasProcessorId());
        answer.addToIndexes();
      }
    }
    ling_dict.clear();
  }

  /**
   * 
   * @param phrase
   *          the sentence we want to count the blanks outside or inside
   * @param start
   *          the start position of sentence we want to count
   * @param end
   *          the end position of sentence we want to count
   * @return the number of blanks
   */
  private int countBlanks(String sentence, int start, int end) {
    int count = 0;
    for (int i = start; i < end; i++) {
      if (sentence.charAt(i) == ' ') {
        count++;
      }
    }
    return count;
  }
}