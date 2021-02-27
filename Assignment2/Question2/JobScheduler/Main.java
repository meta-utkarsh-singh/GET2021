import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		int arr [][]= {{0,10},{6,20},{60,10},{110,5}};
		int numberOfProcess = arr.length;
		JobScheduler jobScheduler = new JobScheduler();
		List<Integer> completionTime = new ArrayList<Integer>();
		completionTime = jobScheduler.findCompletion(arr, numberOfProcess);
		System.out.print(completionTime);
	}

}
