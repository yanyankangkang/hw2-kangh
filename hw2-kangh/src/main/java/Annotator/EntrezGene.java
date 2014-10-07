package Annotator;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.w3c.dom.Document;

import edu.cmu.lti.oaqa.bio.resource_wrapper.Entity;
import edu.cmu.lti.oaqa.bio.resource_wrapper.xml.XMLTree;
import edu.cmu.lti.oaqa.bio.species_mapper.Species;

public class EntrezGene extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
      EntrezGeneDAO eg = new EntrezGeneDAO();
      
      
  }
   

}
