

/* First created by JCasGen Sun Oct 05 15:33:32 EDT 2014 */
package Type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;


/** 
 * Updated by JCasGen Mon Oct 06 21:22:57 EDT 2014
 * XML source: /home/mac/git/hw2-kangh/hw2-kangh/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Abner extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Abner.class);
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
  protected Abner() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Abner(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Abner(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Abner(JCas jcas, int begin, int end) {
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
    if (Abner_Type.featOkTst && ((Abner_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.Abner");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Abner_Type)jcasType).casFeatCode_Words);}
    
  /** setter for Words - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWords(String v) {
    if (Abner_Type.featOkTst && ((Abner_Type)jcasType).casFeat_Words == null)
      jcasType.jcas.throwFeatMissing("Words", "Type.Abner");
    jcasType.ll_cas.ll_setStringValue(addr, ((Abner_Type)jcasType).casFeatCode_Words, v);}    
   
    
  //*--------------*
  //* Feature: Types

  /** getter for Types - gets Protein
DNA
RNA
Cell Line
Cell Type
   * @generated
   * @return value of the feature 
   */
  public String getTypes() {
    if (Abner_Type.featOkTst && ((Abner_Type)jcasType).casFeat_Types == null)
      jcasType.jcas.throwFeatMissing("Types", "Type.Abner");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Abner_Type)jcasType).casFeatCode_Types);}
    
  /** setter for Types - sets Protein
DNA
RNA
Cell Line
Cell Type 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTypes(String v) {
    if (Abner_Type.featOkTst && ((Abner_Type)jcasType).casFeat_Types == null)
      jcasType.jcas.throwFeatMissing("Types", "Type.Abner");
    jcasType.ll_cas.ll_setStringValue(addr, ((Abner_Type)jcasType).casFeatCode_Types, v);}    
  }

    