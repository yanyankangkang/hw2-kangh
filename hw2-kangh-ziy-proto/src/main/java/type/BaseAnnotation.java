

/* First created by JCasGen Thu Oct 09 16:48:44 EDT 2014 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;

 /** 
 * Updated by JCasGen Thu Oct 09 20:01:05 EDT 2014
 * XML source: /home/mac/workspace/11791/hw2-kangh/hw2-kangh-ziy-proto/src/main/resources/descriptors/deiis_types.xml
 *  */
public class BaseAnnotation extends Annotation {
  /** 
   *  
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(BaseAnnotation.class);
  /** 
   *  
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** 
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   *  */
  protected BaseAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * 
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public BaseAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** 
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public BaseAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public BaseAnnotation(JCas jcas, int begin, int end) {
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
   *  modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets ID
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (BaseAnnotation_Type.featOkTst && ((BaseAnnotation_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.BaseAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BaseAnnotation_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets ID 
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (BaseAnnotation_Type.featOkTst && ((BaseAnnotation_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "Type.BaseAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BaseAnnotation_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: Words

  /** getter for Words - gets a line words
   * @generated
   * @return value of the feature 
   */
  public String getWords() {
    if (BaseAnnotation_Type.featOkTst && ((BaseAnnotation_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.BaseAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BaseAnnotation_Type)jcasType).casFeatCode_Words);}
    
  /** setter for Words - sets a line words 
   * @generated
   * @param v value to set into the feature 
   */
  public void setWords(String v) {
    if (BaseAnnotation_Type.featOkTst && ((BaseAnnotation_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.BaseAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BaseAnnotation_Type)jcasType).casFeatCode_Words, v);}    
  }

    