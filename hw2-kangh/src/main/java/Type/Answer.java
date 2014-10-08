

/* First created by JCasGen Sun Oct 05 16:55:37 EDT 2014 */
package Type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;


/** 
 * Updated by JCasGen Mon Oct 06 21:41:18 EDT 2014
 * XML source: /home/mac/workspace/11791/hw2-kangh/hw2-kangh/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Answer extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Answer.class);
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
  protected Answer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Answer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Answer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Answer(JCas jcas, int begin, int end) {
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
  //* Feature: Words

  /** getter for Words - gets 
   * @generated
   * @return value of the feature 
   */
  public String getWords() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Words);}
    
  /** setter for Words - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWords(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Words, v);}    
   
    
  //*--------------*
  //* Feature: Begin

  /** getter for Begin - gets 
   * @generated
   * @return value of the feature 
   */
  public int getBegin() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Begin == null)
      jcasType.jcas.throwFeatMissing("Begin", "Type.Answer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Answer_Type)jcasType).casFeatCode_Begin);}
    
  /** setter for Begin - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setBegin(int v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Begin == null)
      jcasType.jcas.throwFeatMissing("Begin", "Type.Answer");
    jcasType.ll_cas.ll_setIntValue(addr, ((Answer_Type)jcasType).casFeatCode_Begin, v);}    
   
    
  //*--------------*
  //* Feature: End

  /** getter for End - gets 
   * @generated
   * @return value of the feature 
   */
  public int getEnd() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_End == null)
      jcasType.jcas.throwFeatMissing("End", "Type.Answer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Answer_Type)jcasType).casFeatCode_End);}
    
  /** setter for End - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEnd(int v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_End == null)
      jcasType.jcas.throwFeatMissing("End", "Type.Answer");
    jcasType.ll_cas.ll_setIntValue(addr, ((Answer_Type)jcasType).casFeatCode_End, v);}    
   
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_ID, v);}    
  }

    