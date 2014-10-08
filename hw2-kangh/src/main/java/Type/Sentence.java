

/* First created by JCasGen Sat Oct 04 00:16:00 EDT 2014 */
package Type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;


/** 
 * Updated by JCasGen Mon Oct 06 21:41:18 EDT 2014
 * XML source: /home/mac/workspace/11791/hw2-kangh/hw2-kangh/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Sentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Sentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Sentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Sentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Sentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets ID
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets ID 
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets a line words
   * @generated
   * @return value of the feature 
   */
  public String getSentence() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "Type.Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_sentence);}
    
  /** setter for sentence - sets a line words 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "Type.Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_sentence, v);}    
  }

    