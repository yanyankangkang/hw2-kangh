package annotator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * 
 * @author Kang Huang
 * This is just a example of using logisitic regression
 */
public class logisitic_Example {
      private File inputFile; 
      public Logisitic Model;
      private static int N = 5;
      public logisitic_Example() throws FileNotFoundException{
        inputFile = new File("Majority.txt");
        Scanner reader = new Scanner(inputFile);
        Model = new Logisitic(N);
        while(reader.hasNext()){
          double x[] = new double[N];
          double y = 0;
          for (int i = 0; i <= N; i++){
            y = reader.nextDouble();
            if (i < N){
              x[i] = y;
            }
          } 
          Model.get(x, y);
        }
        System.out.print("initialize successfully");
      }
      
      public static void main(String Args[]) throws FileNotFoundException{
        logisitic_Example LR = new logisitic_Example();
        double theta[] = LR.Model.Train(1.0);
        for (int i = 0; i < theta.length; i++){
          System.out.println(theta[i]);
        }
        double x[] = {0, 1, 0, 1, 0};
        System.out.print(LR.Model.Classify(x, theta));
      }
}
