package collectionreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import type.Sentence;

/**
 * Description of class Reader
 * 
 * @author Kang Huang
 * @version 1.0 Build on Sep 23, 2014.
 */
public class Reader extends CollectionReader_ImplBase {

  private File InputFile;

  Scanner reader;

  JCas jcas = null;

  public void initialize() throws ResourceInitializationException {
    System.out.println((String) getConfigParameterValue("inputFile"));
    InputFile = new File((String) getConfigParameterValue("inputFile"));
    try {
      reader = new Scanner(InputFile);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub

    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }
    String textLine = "";
    // text += reader.nextLine();
    // text += "\n";
    textLine = reader.nextLine();
    String s[] = textLine.split(" ", 2);
    Sentence Line = new Sentence(jcas);
    Line.setID(s[0]);
    Line.setWords(s[1]);
    Line.addToIndexes(jcas);
    // jcas.setDocumentText(text);
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
    reader.close();
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    return reader.hasNext();
  }

}