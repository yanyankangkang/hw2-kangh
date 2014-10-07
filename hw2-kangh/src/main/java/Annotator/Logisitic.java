package Annotator;

public class Logisitic {
      private double X[][];
      private double y[];
      private int N;
      private static int volumn = 15000;
      private static double eps = 1e-10;
      private static double MAX_ITER = 1000;
      private static double alpha_decancy = 0.95;
      private static double alpha = 0.2;
      public class costLR{
        double cost;
        double grad[];
        public costLR(double c, double g[]){
          cost = c;
          grad = new double[g.length];
          for (int i = 0; i < g.length; i++){
            grad[i] = g[i];
          }
        }
        public double getCost(){
          return cost;
        }
        public double[] getGrad(){
          return grad;
        }
      }
      public Logisitic(int numberofFeature){
        X = new double [volumn][numberofFeature + 1];
        y = new double [volumn];
        N = 0;
      }
      public void get(double feature[], double answer){
        X[N][0] = 1;
        for(int i = 0; i < feature.length; i++){
            X[N][i + 1] = feature[i];
        }
        y[N] = answer;
        N++;
      }
      
      public double[] Train(double lambda){
        costLR temp;
        double theta[] = new double [X[0].length];
        double d = 1;
        for (int i = 0 ; i < theta.length; i++){
          theta[i] = Math.random();
        }
        double last_cost = 0;
      //  System.out.println("Start Training ...");
        for (int i = 0; i < MAX_ITER; i++){
          System.out.println("iterator" + i);
          temp = cost(X, y, theta, lambda);
          double cost = temp.getCost();
          if (Math.abs(cost - last_cost) < eps){
            return theta;
          }
          System.out.println(cost);
          double grad[] = temp.getGrad();
          last_cost = cost;
          d = d * alpha_decancy;
          for (int j = 0; j < theta.length; j++){
            System.out.print(theta[j] + " ");
          }
          System.out.println();
          update_theta(theta, grad, d * alpha);
          for (int j = 0; j < theta.length; j++){
            System.out.print(theta[j] + " ");
          }
          System.out.println();
        }
        return theta;
      }
      
      public void update_theta(double theta[], double grad[], double alpha){
        for (int i = 0; i < theta.length; i++){
          theta[i] = theta[i] - alpha * grad[i];
        }
      }
      
      public double sigmoid(double sum){
        return 1.0/(1 + Math.exp(-sum));
      }
      
      public double InnerProduct(double x[], double y[]){
        double sum = 0;
        for (int i = 0; i < x.length; i++){
          sum  += x[i] * y[i]; 
        }
        return sum;
      }
      public costLR cost(double X[][],double y[], double theta[], double lambda){
         double cost =  0;
         double grad[] = new double[theta.length];

         for (int i = 0; i < N; i++){
         cost += (-y[i] * Math.log(sigmoid(InnerProduct(theta, X[i]))) - (1 - y[i]) * Math.log(1-sigmoid(InnerProduct(theta, X[i]))));      
         } 
         cost +=  lambda / 2 * InnerProduct(theta, theta);
         for (int k =0 ; k < theta.length; k++){
           for(int j = 0; j < N; j++){
              grad[k] += (sigmoid(InnerProduct(theta, X[j])) - y[j]) * X[j][k];
           }
           grad[k] += lambda * theta[k];  
         }
         return new costLR(cost, grad);
      }
      
      public boolean Classify(double x[], double theta[]){
        double xx[] = new double [x.length + 1];
        xx[0] = 1;
        for (int i = 1; i < xx.length; i++){
          xx[i] = x[i - 1];
        }
        return sigmoid(InnerProduct(xx, theta)) > 0.5;
      }
      
}
