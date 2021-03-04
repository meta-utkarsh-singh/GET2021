import java.util.ArrayList;
import java.util.List;


class JobScheduler {
	/**
	 * 
	 * @param arr
	 * 		requires: 2-d array representing positive arrival time and burst time
	 * @param numberOfProcess
	 * 		requires: non-zero number of process
	 * @return
	 * 		return: List of completion times of process
	 */
	public List<Integer> findCompletion(int arr[][], int numberOfProcess){
		List<Integer> completionTime = new ArrayList<Integer>();
		int indCompletionTime = arr[0][1];
		completionTime.add(0, indCompletionTime);
		for(int i = 1;i<numberOfProcess;i++){
				if(arr[i][0]>indCompletionTime){
					indCompletionTime = arr[i][0]+arr[i][1];
					completionTime.add(i, indCompletionTime);
					continue;
				}
				indCompletionTime = indCompletionTime+arr[i][1];
				completionTime.add(i, indCompletionTime);
		}
		return completionTime;
	}
	/**
	 * 
	 * @param arr
	 * 		requires: 2-d array representing positive arrival time and burst time
	 * @param numberOfProcess
	 * 		requires: non-zero number of process
	 * @return
	 * 		return: List of turn-around times of process
	 */
	public List<Integer> findTurnaround(int arr[][], int numberOfProcess){
		List<Integer> turnaroundTime = new ArrayList<Integer>();
		List<Integer> completionTime = new ArrayList<Integer>();
		completionTime = findCompletion(arr, numberOfProcess);
		for(int i = 0; i<numberOfProcess; i++){
			turnaroundTime.add(i, completionTime.get(i)-arr[i][0]);
		}
		return turnaroundTime;
	}
	/**
	 * 
	 * @param arr
	 * 		requires: 2-d array representing positive arrival time and burst time
	 * @param numberOfProcess
	 * 		requires: non-zero number of process
	 * @return
	 * 		return: List of waiting time times of process
	 */
	public List<Integer> findWaiting(int arr[][], int numberOfProcess){
		List<Integer> waitingTime = new ArrayList<Integer>();
		List<Integer> turnAroundTime = new ArrayList<Integer>();
		turnAroundTime = findTurnaround(arr, numberOfProcess);
		for(int i = 0; i<numberOfProcess; i++){
			waitingTime.add(i, turnAroundTime.get(i)-arr[i][1]);
		}
		return waitingTime;
	}
	/**
	 * 
	 * @param arr 
	 * 			requires: 2-d array representing positive arrival time and burst time
	 * @param numberOfProcess
	 * 			requires: non-zero number of process
	 * @return
	 * 			return: average waiting time for task completion
	 */
	public double findAverageWaiting(int arr[][], int numberOfProcess){
		double averageWaitingTime = 0;
		List<Integer> waitingTime = new ArrayList<Integer>();
		waitingTime = findWaiting(arr, numberOfProcess);
		for(int i = 0; i<numberOfProcess; i++){
			averageWaitingTime = averageWaitingTime + waitingTime.get(i);
		}
		averageWaitingTime = averageWaitingTime/numberOfProcess;
		return averageWaitingTime;
	}
	/**
	 * 
	 * @param arr
	 * 			requires: 2-d array representing positive arrival time and burst time
	 * @param numberOfProcess
	 * 			requires: non-zero number of process
	 * @return
	 * 			return: maximum waiting time
	 */
	public double maxWaitingTime(int arr[][], int numberOfProcess) {
		int maxWaiting = 0;
		List<Integer> waitingTime = new ArrayList<Integer>();
		waitingTime = findWaiting(arr, numberOfProcess);
		for(int i = 0 ; i < numberOfProcess ; i++){
			maxWaiting = Math.max(maxWaiting, waitingTime.get(i));
		}
		return maxWaiting;
	}
}