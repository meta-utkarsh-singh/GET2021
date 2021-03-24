import java.util.*; 
public class SelectOrder {
	/**
	 * 
	 * @param arr array for which heapify function needs to be performed
	 * @param size size of array
	 * @param index index of leaf node
	 */
	private void heapify(Pair[] arr, int size, int index) {
		int largestIndex = index;
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;
		
		if(leftChild < size && arr[leftChild].getNoOfBalls() >
				arr[largestIndex].getNoOfBalls()){
			largestIndex = leftChild;
		}
		if(rightChild < size && arr[rightChild].getNoOfBalls() >
				arr[largestIndex].getNoOfBalls()){
			largestIndex = rightChild;
		}
		if(largestIndex != index) {
			Pair swap = arr[index];
			arr[index] = arr[largestIndex];
			arr[largestIndex] = swap;
			heapify(arr,size,largestIndex);
		}
	}
	/**
	 * 
	 * @param arr array for which heap needs to be built
	 */
	private void buildHeap(Pair arr[]) {
		int index = (arr.length)/2 - 1;
		for(int i = index ; i >= 0 ; i--){
			heapify(arr,arr.length, i);
		}
	}
	/**
	 * 
	 * @param arr list representing number of 
	 * 		  balls left to be bowled by each bowler
	 * @param noOfBallsFace no of balls to be faced by bats-men
	 * @param noOfBallers total no of bowlers
	 * @return list of order in which the bowlers bowl
	 */
	public List<Integer> getOrder(List<Integer> arr, int noOfBallsFace, int noOfBallers){
		if(arr.size() == 0){
			return null;
		}
		int sumOfTotalBalls = 0;
		for(int i = 0 ; i < arr.size() ; i++){
			sumOfTotalBalls += arr.get(i);
		}
		if(sumOfTotalBalls < noOfBallsFace) {
			return null;
		}
		Pair[] bowlers = new Pair[arr.size()];
		List<Integer> ansArr = new ArrayList<Integer>();
		int totalBallsFaced = 0;
		for(int i = 0 ; i < arr.size() ; i++) {
			bowlers[i] = new Pair(i+1, arr.get(i));
		}
		buildHeap(bowlers);
		while(totalBallsFaced < noOfBallsFace){
			totalBallsFaced++;
			ansArr.add(bowlers[0].getBowlerNo());
			bowlers[0].set(bowlers[0].getNoOfBalls()-1);
			buildHeap(bowlers);
			
		}
		return ansArr;
	}
}
