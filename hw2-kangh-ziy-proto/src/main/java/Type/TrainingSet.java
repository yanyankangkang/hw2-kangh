

/* First created by JCasGen Mon Oct 06 21:22:57 EDT 2014 */
package Type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;
import org.apache.uima.jcas.cas.DoubleArray;


/** 
 * Updated by JCasGen Mon Oct 06 21:22:57 EDT 2014
 * XML source: /home/mac/git/hw2-kangh/hw2-kangh/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class TrainingSet extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TrainingSet.class);
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
  protected TrainingSet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TrainingSet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TrainingSet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TrainingSet(JCas jcas, int begin, int end) {
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
  //* Feature: X

  /** getter for X - gets 
   * @generated
   * @return value of the feature 
   */
  public DoubleArray getX() {
    if (TrainingSet_Type.featOkTst && ((TrainingSet_Type)jcasType).casFeat_X == null)
      jcasType.jcas.throwFeatMissing("X", "Type.TrainingSet");
    return (DoubleArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingSet_Type)jcasType).casFeatCode_X)));}
    
  /** setter for X - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setX(DoubleArray v) {
    if (TrainingSet_Type.featOkTst && ((TrainingSet_Type)jcasType).casFeat_X == null)
      jcasType.jcas.throwFeatMissing("X", "Type.TrainingSet");
    jcasType.ll_cas.ll_setRefValue(addr, ((TrainingSet_Type)jcasType).casFeatCode_X, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for X - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public double getX(int i) {
    if (TrainingSet_Type.featOkTst && ((TrainingSet_Type)jcasType).casFeat_X == null)
      jcasType.jcas.throwFeatMissing("X", "Type.TrainingSet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingSet_Type)jcasType).casFeatCode_X), i);
    return jcasType.ll_cas.ll_getDoubleArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingSet_Type)jcasType).casFeatCode_X), i);}

  /** indexed setter for X - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setX(int i, double v) { 
    if (TrainingSet_Type.featOkTst && ((TrainingSet_Type)jcasType).casFeat_X == null)
      jcasType.jcas.throwFeatMissing("X", "Type.TrainingSet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingSet_Type)jcasType).casFeatCode_X), i);
    jcasType.ll_cas.ll_setDoubleArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingSet_Type)jcasType).casFeatCode_X), i, v);}
  }

    