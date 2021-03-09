
public class SelectOrder {
	private void heapify(int arr[], int n, int i){
		int largest = i;
		int leftChild = 2*i+1;
		int rightChild = 2*i+2;
		if(leftChild < n && arr[largest] < arr[leftChild]){
			largest = leftChild;
		}
		if(rightChild < n && arr[largest] < arr[rightChild]){
			largest = rightChild;
		}
		if(largest != i){
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}
	private void deleteRootHeap(int arr[], int index){
		int largeIndex = index;
		int right = 2*index + 2;
		int left = 2*index + 1;
		if(right < arr.length && arr[largeIndex] < arr[right]){
			largeIndex = right;
		}
		if(left < arr.length && arr[largeIndex] < arr[left]){
			largeIndex = left;
		}
		if(largeIndex == index){
			return;
		}
		int temp = arr[index];
		arr[index] = arr[largeIndex];
		arr[largeIndex] = temp;
		deleteRootHeap(arr, largeIndex);
	}
	private int[] buildHeap(int arr[]){
		int index = ((arr.length)/2) - 1;
		while(index >= 0){
			heapify(arr, arr.length, index);
			index--;
		}
		return arr;
	}
	public int[] getOrder(int arr[], int noOfBallsFace, int noOfBallers){
		int[] heap = buildHeap(arr);
		for(int i = 0 ; i < heap.length ; i++){
			System.out.print(heap[i]+" ");
		}
		System.out.println();
		int ansArr[] = new int[noOfBallsFace];
		for(int i = 0 ; i < noOfBallsFace ; i++){
			ansArr[i] = heap[i];
			deleteRootHeap(heap, 0);
		}
		return ansArr;
	}
}
