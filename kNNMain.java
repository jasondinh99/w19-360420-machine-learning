import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	
	List<DataPoint> datalist = DataSet.readDataSet("data/iris.csv");
	double[][] xArray = new double[datalist.size()][datalist.size()];
	
	//for(int i = 0; i < datalist.size(); i++){
		DataPoint dp = datalist.get(1);
		xArray[1] = dp.getX();
		String printX = Arrays.toString(xArray[1]);
		System.out.print(printX + "\t");
		System.out.println(dp.getLabel());
	//}
	
	/*
	for(int i = 0; i < xArray.length; i++){
		for(int j = 0; j < xArray[i].length; j++){
			System.out.print(xArray[i][j]+"\t");
		}
		System.out.println();
	}
	*/


    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset

	List<DataPoint> trainSet = DataSet.getTestSet(datalist, 0.80);
	List<DataPoint> testSet = DataSet.getTrainingSet(datalist, 0.20);

	
    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)



    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label



    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.


  }

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
