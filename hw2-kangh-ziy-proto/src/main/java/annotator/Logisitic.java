package annotator;
/**
 * 
 * @author Kang Huang
 * @version 1.0 Build on Oct 8, 2014.
 * contain basic operations of logistic regression, the number of features is unlimited
 */
public class Logisitic {
  private double _X[][];

  private double _y[];

  private int _N;

  private static int _volumn = 15000;

  private static double _eps = 1e-10;

  private static double _MAX_ITER = 1000;

  private static double _alpha_decancy = 0.95;

  private static double _alpha = 0.2;

  public class costLR {
    double cost;

    double grad[];
    /**
     * structure of returning parameters
     * @param c cost
     * @param g gradient
     */
    public costLR(double c, double g[]) {
      cost = c;
      grad = new double[g.length];
      for (int i = 0; i < g.length; i++) {
        grad[i] = g[i];
      }
    }

    public double getCost() {
      return cost;
    }

    public double[] getGrad() {
      return grad;
    }
  }
  /**
   * 
   * @param numberofFeature
   */
  public Logisitic(int numberofFeature) {
    _X = new double[_volumn][numberofFeature + 1];
    _y = new double[_volumn];
    _N = 0;
  }

  public void get(double feature[], double answer) {
    _X[_N][0] = 1;
    for (int i = 0; i < feature.length; i++) {
      _X[_N][i + 1] = feature[i];
    }
    _y[_N] = answer;
    _N++;
  }
 /**
  * Training the model 
  * @param lambda the regularization factor
  * @return parameters of LR
  */
  public double[] Train(double lambda) {
    costLR temp;
    double theta[] = new double[_X[0].length];
    double d = 1;
    for (int i = 0; i < theta.length; i++) {
      theta[i] = Math.random();
    }
    double last_cost = 0;
    // System.out.println("Start Training ...");
    for (int i = 0; i < _MAX_ITER; i++) {
      System.out.println("iterator" + i);
      temp = cost(_X, _y, theta, lambda);
      double cost = temp.getCost();
      if (Math.abs(cost - last_cost) < _eps) {
        return theta;
      }
      System.out.println(cost);
      double grad[] = temp.getGrad();
      last_cost = cost;
      d = d * _alpha_decancy;
      for (int j = 0; j < theta.length; j++) {
        System.out.print(theta[j] + " ");
      }
      System.out.println();
      update_theta(theta, grad, d * _alpha);
      for (int j = 0; j < theta.length; j++) {
        System.out.print(theta[j] + " ");
      }
      System.out.println();
    }
    return theta;
  }
  /**
   * 
   * @param theta the parameter of LR
   * @param grad  the gradient of each iteration
   * @param alpha the learning rate
   */
  public void update_theta(double theta[], double grad[], double alpha) {
    for (int i = 0; i < theta.length; i++) {
      theta[i] = theta[i] - alpha * grad[i];
    }
  }

  public double sigmoid(double sum) {
    return 1.0 / (1 + Math.exp(-sum));
  }

  public double InnerProduct(double x[], double y[]) {
    double sum = 0;
    for (int i = 0; i < x.length; i++) {
      sum += x[i] * y[i];
    }
    return sum;
  }
  /**
   * @param X the training data 
   * @param y the label of training data
   * @param theta parameters of LR
   * @param lambda regularization factor
   * @return [cost, grad]
   */
  public costLR cost(double X[][], double y[], double theta[], double lambda) {
    double cost = 0;
    double grad[] = new double[theta.length];

    for (int i = 0; i < _N; i++) {
      cost += (-y[i] * Math.log(sigmoid(InnerProduct(theta, X[i]))) - (1 - y[i])
              * Math.log(1 - sigmoid(InnerProduct(theta, X[i]))));
    }
    cost += lambda / 2 * InnerProduct(theta, theta);
    for (int k = 0; k < theta.length; k++) {
      for (int j = 0; j < _N; j++) {
        grad[k] += (sigmoid(InnerProduct(theta, X[j])) - y[j]) * X[j][k];
      }
      grad[k] += lambda * theta[k];
    }
    return new costLR(cost, grad);
  }
  /**
   * classify new instance
   * @param x new instance
   * @param theta parameters of LR
   * @return true/false
   */
  public boolean Classify(double x[], double theta[]) {
    double xx[] = new double[x.length + 1];
    xx[0] = 1;
    for (int i = 1; i < xx.length; i++) {
      xx[i] = x[i - 1];
    }
    return sigmoid(InnerProduct(xx, theta)) > 0.5;
  }

}
