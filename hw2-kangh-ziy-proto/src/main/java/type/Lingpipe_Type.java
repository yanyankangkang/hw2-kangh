
/* First created by JCasGen Sat Oct 04 00:17:17 EDT 2014 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;


/** 
 * Updated by JCasGen Thu Oct 09 18:10:12 EDT 2014
 *  */
public class Lingpipe_Type extends BaseAnnotation_Type {
  /**  
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /**  */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Lingpipe_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Lingpipe_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Lingpipe(addr, Lingpipe_Type.this);
  			   Lingpipe_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Lingpipe(addr, Lingpipe_Type.this);
  	  }
    };
  /**  */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Lingpipe.typeIndexID;
  /**  
      */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("Type.Lingpipe");
 
  /** initialize variables to correspond with Cas Type and Features
	 * 
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Lingpipe_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }
}



    