import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	String file = "data/breastCancer.csv"; //new String(args[0]);
	
	List<DataPoint> datalist = DataSet.readDataSet(file);
	DataPoint dp = datalist.get(1);
	
	//double[][] xArray = new double[datalist.size()][5];
	/*
	for(int i = 0; i < datalist.size(); i++){
		DataPoint dp = datalist.get(i);
		xArray[i] = dp.getX();
		String printX = Arrays.toString(xArray[i]);
		System.out.print(printX + "\t");
		System.out.println(dp.getLabel());
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
	int k = 10;
	KNNClassifier classify = new KNNClassifier(k);
	DataPoint[] near = classify.getNearestNeighbors(trainSet, testSet.get(0));
	//System.out.println("Predicted target " + classify.predict(testSet, dp));


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	double good = 0.;
	double numTest = testSet.size();
	
	for(int i = 0; i < testSet.size(); i++){
		DataPoint comparePoint = testSet.get(i);
		String predict = classify.predict(trainSet, comparePoint);
		
		if(comparePoint.getLabel().equals(predict)){
			good++;
		}
		
	}

	double accuracy = good/numTest * 100;
	System.out.println("Accuracy: " + accuracy);

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
