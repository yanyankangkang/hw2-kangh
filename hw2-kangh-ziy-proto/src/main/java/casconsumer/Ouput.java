package casconsumer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import type.Abner;
import type.Answer;
import type.Lingpipe;
import type.Sentence;

/**
 * Description of class Consumer
 * 
 * @author Kang Huang
 * @version 1.0 Build on Sep 23, 2014.
 */
public class Ouput extends CasConsumer_ImplBase {
  private File outputFile = null;

  private File out = null;

  private static String outputPath = "outputFile";

  private static String missWordFilePath = "missing";

  private Writer writer = null;

  private Writer subwriter = null;

  private File testFile = null;

  private HashMap<String, Integer> table = new HashMap<String, Integer>();

  private int hit = 0, miss = 0, words = 0;

  /***********************************************************
   * //test private HashMap<String, Lingpipe> ling_dict = new HashMap<String, Lingpipe>(); private
   * double X[][] = new double [20][2]; private int N = 0;
   *************************************************************/
  @Override
  public void initialize() throws ResourceInitializationException {

    // System.out.println("*************");
    try {
      outputFile = new File((String) getConfigParameterValue(outputPath));
      writer = new BufferedWriter(new FileWriter(outputFile));
      // out = new File((String) getConfigParameterValue(missWordFilePath));
      // subwriter = new BufferedWriter(new FileWriter(out));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
 /*   testFile = new File("sample.out");
    Scanner dict = null;
    try {
      dict = new Scanner(testFile);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    while (dict.hasNext()) {
      table.put(dict.nextLine(), 0);
    }
    words = table.size();*/
  }

  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    /********************************************************
     * //test N = 0; FSIterator<Annotation> Lingpipe_it =
     * jcas.getAnnotationIndex(Lingpipe.type).iterator(); while (Lingpipe_it.hasNext()) { Lingpipe
     * Ling = (Lingpipe) Lingpipe_it.next(); ling_dict.put(Ling.getWords(), Ling); }
     * FSIterator<Annotation> abner_it = jcas.getAnnotationIndex(Abner.type).iterator(); while
     * (abner_it.hasNext()) { Abner abner = (Abner) abner_it.next(); String word = abner.getWords();
     * X[N][1] = 1; if (ling_dict.containsKey(word)) { X[N][0] =
     * ling_dict.get(word).getConfidence(); ling_dict.remove(word); } else{ X[N][0] = 0; } N++; }
     * for (String word : ling_dict.keySet()){ X[N][0] = ling_dict.get(word).getConfidence();
     * X[N][1] = 0; N++; }
     ******************************************************/
    // test
    // HashMap<String, Integer> hash = new HashMap<String, Integer>();
    FSIterator<Annotation> it = jcas.getAnnotationIndex(Answer.type).iterator();
    FSIterator<Annotation> line_it = jcas.getAnnotationIndex(Sentence.type).iterator();
    Sentence Line = (Sentence) line_it.next();
    while (it.hasNext()) {
      Answer res = (Answer) it.next();
      // System.out.println(line_it.next());
      String phrase = res.getWords();
      String ans;
     /* if (phrase.equalsIgnoreCase("alkaline phosphatase")){
          System.out.println(phrase  + res.getCasProcessorId());
      }*/
    /*  if (res.getCasProcessorId().equalsIgnoreCase("LingPipe")){
      int outershift = countBlanks(Line.getSentence(), 0, res.getBegin());
      int innershift = countBlanks(Line.getSentence(), res.getBegin(), res.getEnd());
      ans = res.getID() + "|" + (res.getBegin() - outershift) + " "
              + (res.getEnd() - outershift - innershift - 1) + "|" + phrase;
      }*/
      //else{
      ans = res.getID() + "|" + res.getBegin() + " " + res.getEnd() + "|" + phrase;
     // }
      // System.out.println(res.getID() + "    " + res.getWords());
      try {      
        writer.write(ans + "\n");
        Match(ans);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    //
  }
  /* public void collectionProcessComplete(){
     try {
       writer.flush();
       writer.close();
       System.out.println("Success");
     } catch (IOException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
     }
     System.out.println(hit + "  " + miss);
     double P = hit * 1.0 / (hit + miss);
     double R = hit * 1.0 / words;
     System.out.println("Precision: " + P + " " + "Recall: " + R + "\n" + "F1-Meause: " + 2 * P * R
             / (P + R));
   }
*/
   @Override
   public void destroy() {
     try {
       writer.flush();
       writer.close();
       System.out.println("Success");
     } catch (IOException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
     }
     System.out.println(hit + "  " + miss);
     double P = hit * 1.0 / (hit + miss);
     double R = hit * 1.0 / words;
     System.out.println("Precision: " + P + " " + "Recall: " + R + "\n" + "F1-Meause: " + 2 * P * R
             / (P + R));
   }
  /**
   * find whether phrase exists in standard answer set
   * 
   * @param phrase
   * @throws IOException
   */
  private void Match(String phrase) throws IOException {
    if (table.containsKey(phrase)) {
      hit++;
    } else {
      miss++;
      // subwriter.write(phrase + "\n");
    }
  }

  private int countBlanks(String phrase, int start, int end) {
    int count = 0;
    for (int i = start; i < end; i++) {
      if (phrase.charAt(i) == ' ') {
        count++;
      }
    }
    return count;
  }
}