
/* First created by JCasGen Sun Oct 05 15:33:32 EDT 2014 */
package Type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import edu.cmu.deiis.types.Annotation_Type;

/** 
 * Updated by JCasGen Mon Oct 06 21:41:18 EDT 2014
 * @generated */
public class Abner_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Abner_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Abner_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Abner(addr, Abner_Type.this);
  			   Abner_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Abner(addr, Abner_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Abner.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("Type.Abner");
 
  /** @generated */
  final Feature casFeat_Words;
  /** @generated */
  final int     casFeatCode_Words;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getWords(int addr) {
        if (featOkTst && casFeat_Words == null)
      jcas.throwFeatMissing("Words", "Type.Abner");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Words);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setWords(int addr, String v) {
        if (featOkTst && casFeat_Words == null)
      jcas.throwFeatMissing("Words", "Type.Abner");
    ll_cas.ll_setStringValue(addr, casFeatCode_Words, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Types;
  /** @generated */
  final int     casFeatCode_Types;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTypes(int addr) {
        if (featOkTst && casFeat_Types == null)
      jcas.throwFeatMissing("Types", "Type.Abner");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Types);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTypes(int addr, String v) {
        if (featOkTst && casFeat_Types == null)
      jcas.throwFeatMissing("Types", "Type.Abner");
    ll_cas.ll_setStringValue(addr, casFeatCode_Types, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Abner_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Words = jcas.getRequiredFeatureDE(casType, "Words", "uima.cas.String", featOkTst);
    casFeatCode_Words  = (null == casFeat_Words) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Words).getCode();

 
    casFeat_Types = jcas.getRequiredFeatureDE(casType, "Types", "uima.cas.String", featOkTst);
    casFeatCode_Types  = (null == casFeat_Types) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Types).getCode();

  }
}



    