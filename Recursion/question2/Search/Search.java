
public class Search {
	private int indexLinearSearch = 0;
	/**
	 * 
	 * @param arr array in which the target value needs to be found
	 * @param value value to be found
	 * @return index at which the value is found , -1 in other cases
	 */
	public int linearSearch(int arr[], int value){
		if(indexLinearSearch == arr.length){
			return -1;
		}
		if(arr[indexLinearSearch] == value){
			return indexLinearSearch;
		}
		indexLinearSearch++;
		return linearSearch(arr, value);
	}
	/**
	 * 
	 * @param arr sorted array in which the value needs to be searched
	 * @param value value that needs to be searched
	 * @param left starting index of array
	 * @param right ending index of array
	 * @return index where value is found, -1 in other cases
	 */
	public int binarySearch(int arr[], int value, int left, int right){
		int mid = (int) ((left+right)/2);
		System.out.println(left+" "+right);
		if(mid < arr.length && arr[mid] == value){
			return mid;
		}
		if(left >= right){
			System.out.println(left);
			return -1;
		}
		if(arr[mid] > value){
			return binarySearch(arr, value, left, mid);
		}
		else {
			return binarySearch(arr, value, mid+1, right);
		}
	}
}
