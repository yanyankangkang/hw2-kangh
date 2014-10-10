package Annotator;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import edu.cmu.lti.oaqa.bio.resource_wrapper.Entity;
import edu.cmu.lti.oaqa.bio.resource_wrapper.ID;
import edu.cmu.lti.oaqa.bio.resource_wrapper.Relation;
import edu.cmu.lti.oaqa.bio.resource_wrapper.ResourceWrapper;
import edu.cmu.lti.oaqa.bio.resource_wrapper.ResourceWrapperExtended;
import edu.cmu.lti.oaqa.bio.resource_wrapper.xml.XMLNode;
import edu.cmu.lti.oaqa.bio.resource_wrapper.xml.XMLTree;
import edu.cmu.lti.oaqa.bio.species_mapper.Species;

/**
 * A class to wrap the functionality of Entrez Gene E-Utilities, primarily search and fetch.
 * Search and summary results are cached locally for faster retrieval.
 * 
 * See EntrezGeneDAOExample for generic uses of this class.
 * 
 * @author Collin McCormack (cmccorma)
 * @version 0.3
 */
public class EntrezGeneDAO {
  
  private static final String baseURL = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/";
  private static final String esearch = baseURL + "esearch.fcgi?db=gene&term=";
  private static final String esummary =  baseURL + "esummary.fcgi?db=gene&id=";
  private static final String summarySuffix = "[gene] AND alive[prop]";
  private static final String efetch = baseURL + "efetch.fcgi?db=gene&retmode=xml&id=";
  private static DocumentBuilderFactory xmlDBF = DocumentBuilderFactory.newInstance();
  
  private HashMap<String,ArrayList<String>> searchCache;
  private HashMap<String,String> idLookupCache;
  
  /**
   * Creates a new EntrezGene object (creates new caches).
   */
  public EntrezGeneDAO() {
    this.searchCache = new HashMap<String,ArrayList<String>>();
    this.idLookupCache = new HashMap<String,String>();
  }
  
  /**
   * Uses the Entrez Gene web service to search the database using the contents of queryTerms.  By default, returns 20 results.</br>
   * The result can be plugged right into 'fetch' to get Entity's</br>
   * Search results are cached by url.
   * 
   * @param queryTerms  a String query
   * @return        an ArrayList<String> of EntrezGene UID's, empty ArrayList<String> on error
   * @throws IOException
   */
  public boolean search(String queryTerms) throws IOException {
    /* Possible Exceptions:
     *    UnsupportedEncodingException - URLEncoder
     *    MalformedURLException - URL constructor
     *    IOException - URL.connect
     */
    
    // Construct HTTP request URL
    String urlStr = esearch;
   // System.out.println("Searching \"" + queryTerms + "\"...");  reserve
    urlStr += queryTerms.replace(' ', '+') + summarySuffix;
   // System.out.println(urlStr);  reserve
    
    if (this.searchCache.containsKey(urlStr)) {
      return true;
    }
    
    URL url = new URL(urlStr);

    // Open URL and get XML result
    InputStream connStream = url.openStream();
    XMLTree xml = null;
    try {
      xml = new XMLTree(parseXmlResult(connStream));
    } catch (NullPointerException ne) {
      return false;
    }
    
    // Something went wrong and just return an empty list
    if (xml.getRoot() == null)
      return false;
    
    // Parse XML and return ID's
    ArrayList<XMLNode> ids = xml.findNodes("Id");
    return ids.size() > 0;
  }
  /**
   * Query the Entrez Gene web service for additional information associated with an ID.
   * @param id Entrez Gene ID String
   * @return String name of the item associated with the supplied ID
   * @throws IOException
   */
 
  /**
   * Uses the Entrez Gene web service to fetch an entry based on a unique Entrez Gene UID.  
   * The XML response is parsed and the relevant information extracted into a Entity object, which is returned.
   * 
   * @param id the Entrez Gene UID to fetch (String)
   * @return an Entity object containing the information from the response, null if XMl is absent, malformed, or does not contain a name
   * @throws IOException
   */

  /**
   * Method for parsing XML responses to DOM Document's (encapsulated here because the Java way of doing it is so obtuse).
   * @param stream  InputStream of XML information
   * @return      XML DOM Document
   */
  private static Document parseXmlResult(InputStream stream) {
    DocumentBuilder xmlReader;
    try {
      xmlReader = xmlDBF.newDocumentBuilder();
      return xmlReader.parse(stream);
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("Bad connection.");
      e.printStackTrace();
    }
    return null;
  }
  
  

}
