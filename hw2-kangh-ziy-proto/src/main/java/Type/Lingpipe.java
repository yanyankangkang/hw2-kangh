

/* First created by JCasGen Sat Oct 04 00:17:17 EDT 2014 */
package Type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;


/** 
 * Updated by JCasGen Mon Oct 06 21:22:57 EDT 2014
 * XML source: /home/mac/git/hw2-kangh/hw2-kangh/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Lingpipe extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Lingpipe.class);
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
  protected Lingpipe() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Lingpipe(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Lingpipe(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Lingpipe(JCas jcas, int begin, int end) {
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

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.Lingpipe");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.Lingpipe");
    jcasType.ll_cas.ll_setStringValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: Words

  /** getter for Words - gets 
   * @generated
   * @return value of the feature 
   */
  public String getWords() {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.Lingpipe");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_Words);}
    
  /** setter for Words - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWords(String v) {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.Lingpipe");
    jcasType.ll_cas.ll_setStringValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_Words, v);}    
   
    
  //*--------------*
  //* Feature: Begin

  /** getter for Begin - gets 
   * @generated
   * @return value of the feature 
   */
  public int getBegin() {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_Begin == null)
      jcasType.jcas.throwFeatMissing("Begin", "Type.Lingpipe");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_Begin);}
    
  /** setter for Begin - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setBegin(int v) {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_Begin == null)
      jcasType.jcas.throwFeatMissing("Begin", "Type.Lingpipe");
    jcasType.ll_cas.ll_setIntValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_Begin, v);}    
   
    
  //*--------------*
  //* Feature: End

  /** getter for End - gets 
   * @generated
   * @return value of the feature 
   */
  public int getEnd() {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_End == null)
      jcasType.jcas.throwFeatMissing("End", "Type.Lingpipe");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_End);}
    
  /** setter for End - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEnd(int v) {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_End == null)
      jcasType.jcas.throwFeatMissing("End", "Type.Lingpipe");
    jcasType.ll_cas.ll_setIntValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_End, v);}    
   
    
  //*--------------*
  //* Feature: Confidence

  /** getter for Confidence - gets 
   * @generated
   * @return value of the feature 
   */
  public double getConfidence() {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "Type.Lingpipe");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_Confidence);}
    
  /** setter for Confidence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidence(double v) {
    if (Lingpipe_Type.featOkTst && ((Lingpipe_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "Type.Lingpipe");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Lingpipe_Type)jcasType).casFeatCode_Confidence, v);}    
  }

    