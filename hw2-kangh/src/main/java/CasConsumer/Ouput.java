package CasConsumer;

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

import Type.Answer;
import Type.Lingpipe;
import Type.Sentence;
/** Description of class Consumer 
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
    testFile = new File("sample.out");
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
      words = table.size();
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
    // HashMap<String, Integer> hash = new HashMap<String, Integer>();
    FSIterator<Annotation> it = jcas.getAnnotationIndex(Answer.type).iterator();
    FSIterator<Annotation> line_it = jcas.getAnnotationIndex(Sentence.type).iterator();
    Sentence Line = (Sentence) line_it.next();
    while (it.hasNext()) {
      Answer res = (Answer) it.next();
    //  System.out.println(line_it.next());
      String phrase = res.getWords();
      int  outershift = countBlanks(Line.getSentence(), 0, res.getBegin() );
      int  innershift = countBlanks(Line.getSentence(), res.getBegin(), res.getEnd());
      try {
        String ans = res.getID() + "|" + (res.getBegin() - outershift) + " "
                + (res.getEnd() - outershift - innershift - 1) + "|"
                + phrase;
       // System.out.println(res.getID() + "    " + res.getWords());
        writer.write(ans + "\n");
        Match(ans);
        // }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
   }
  //  
  }
  
  /*public void close() throws IOException{
    close();
  }*/
  @Override
  public void destroy(){
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
   * @param phrase
   * @throws IOException 
   */
  private void Match(String phrase) throws IOException{
    if (table.containsKey(phrase)) {
      hit++;
    } else {
      miss++;
  //    subwriter.write(phrase + "\n");
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