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

import Annotator.Logisitic;
import Type.Abner;
import Type.Answer;
import Type.Lingpipe;
import Type.Sentence;

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

  private HashMap<String, Lingpipe> ling_dict = new HashMap<String, Lingpipe>();

  private double X[][] = new double[50][2];

  private double y[] = new double[50];

  private int N = 0;

  private Logisitic Model;

  @Override
  public void initialize() throws ResourceInitializationException {

    Model = new Logisitic(2);
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
      String temp[] = dict.nextLine().split("\\|");
      table.put(temp[2], 0);
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

    N = 0;
    FSIterator<Annotation> Lingpipe_it = jcas.getAnnotationIndex(Lingpipe.type).iterator();
    while (Lingpipe_it.hasNext()) {
      Lingpipe Ling = (Lingpipe) Lingpipe_it.next();
      ling_dict.put(Ling.getWords(), Ling);
    }
    FSIterator<Annotation> abner_it = jcas.getAnnotationIndex(Abner.type).iterator();
    while (abner_it.hasNext()) {
      Abner abner = (Abner) abner_it.next();
      String word = abner.getWords();
      X[N][1] = 1;
      if (ling_dict.containsKey(word)) {
        X[N][0] = ling_dict.get(word).getConfidence();
        ling_dict.remove(word);
      } else {
        X[N][0] = 0;
      }
      if (table.containsKey(word)) {
        y[N] = 1;
      } else {
        y[N] = 0;
      }
      N++;
    }

    for (String word : ling_dict.keySet()) {
    //  System.out.println(N);
      X[N][0] = ling_dict.get(word).getConfidence();
      X[N][1] = 0;
      if (table.containsKey(word)) {
        y[N] = 1;
      } else {
        y[N] = 0;
      }
      N++;
    }
    for (int i = 0; i < N; i++){
      Model.get(X[i], y[i]);
    }
    ling_dict.clear();
    //
  }

  /*
   * public void close() throws IOException{ close(); }
   */
  @Override
  public void destroy() {
    double theta[] = Model.Train(1.0);
    for (int i = 0; i < theta.length; i++){
      System.out.println(theta[i]);
    }
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