
/* First created by JCasGen Thu Oct 09 16:48:44 EDT 2014 */
package type;

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
 * Updated by JCasGen Thu Oct 09 18:10:12 EDT 2014
 *  */
public class BaseAnnotation_Type extends Annotation_Type {
  /**  
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /**  */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (BaseAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = BaseAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new BaseAnnotation(addr, BaseAnnotation_Type.this);
  			   BaseAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new BaseAnnotation(addr, BaseAnnotation_Type.this);
  	  }
    };
  /**  */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = BaseAnnotation.typeIndexID;
  /**  
      */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("Type.BaseAnnotation");
 
  /**  */
  final Feature casFeat_ID;
  /**  */
  final int     casFeatCode_ID;
  /** 
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getID(int addr) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "Type.BaseAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ID);
  }
  /** 
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setID(int addr, String v) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "Type.BaseAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_ID, v);}
    
  
 
  /**  */
  final Feature casFeat_Words;
  /**  */
  final int     casFeatCode_Words;
  /** 
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getWords(int addr) {
        if (featOkTst && casFeat_Words == null)
      jcas.throwFeatMissing("Words", "Type.BaseAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Words);
  }
  /** 
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setWords(int addr, String v) {
        if (featOkTst && casFeat_Words == null)
      jcas.throwFeatMissing("Words", "Type.BaseAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_Words, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * 
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public BaseAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ID = jcas.getRequiredFeatureDE(casType, "ID", "uima.cas.String", featOkTst);
    casFeatCode_ID  = (null == casFeat_ID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ID).getCode();

 
    casFeat_Words = jcas.getRequiredFeatureDE(casType, "Words", "uima.cas.String", featOkTst);
    casFeatCode_Words  = (null == casFeat_Words) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Words).getCode();

  }
}



    