
public class ArrOperation {
	/**
	 * 
	 * @param arr array of size > 0
	 * 		  in which the mirror elements 
	 * 		  size need to be found.
	 * @return maximum length of mirror elements.
	 */
	public int maxMirror(int arr[]){
		int length = arr.length;
		assert(length > 0);
		int mirrorSize = 1;
		int maxMirrorSize = 0;
		for(int i = 0 ; i < length ; i++){
			int k = i;
			for(int j = length - 1 ; j > 0 && k<length ; j--){
				if(arr[k] == arr[j]){
					mirrorSize++;
					k++;
				}
				else {
					k = i;
					maxMirrorSize = Math.max(maxMirrorSize, mirrorSize);
					mirrorSize = 0;
				}
			}
		}
		return maxMirrorSize;
	}
	/**
	 * 
	 * @param array of non zero length
	 * @return number of clumps in array
	 */
	public int numberOfClumps(int arr[]) {
		int numberClumps = 0;
		int length = arr.length;
		assert(length > 0);
		int count = 1;
		for(int i = 1 ; i < length ; i++){
			if(arr[i] == arr[i-1]){
				count++;
				continue;
			}
			if(count >= 2){
				numberClumps++;
			}
			count = 1;
		}
		if(count >= 2){
			numberClumps++;
		}
		System.out.println(numberClumps);
		return numberClumps;
	}
	/**
	 * 
	 * @param array of non-zero length
	 * @return index at which the sum of first 
	 * 		   part equals the sum of second part.
	 */
	public int splitArray(int arr[]){
		int index = -1;
		int length = arr.length;
		int sum = 0;
		int sumI = 0;
		assert(length > 0);
		for(int i = 0 ; i < length ; i++){
			sum = sum + arr[i];
		}
		for(int i = 0 ; i < length ; i++){
			sumI = sumI + arr[i];
			if(sumI == sum/2) {
				index = i + 1;
			}
		}
		return index;
	}
	/**
	 * 
	 * @param arr array of non-zero length
	 * @param X integer 
	 * @param Y integer
	 * @return returns fixed array where 
	 * 		   X is always appended by Y,
	 * 		   assertion error in other cases
	 */
	public int[] fixXY(int arr[], int X, int Y){
		int length = arr.length;
		assert(length > 0);
		assert(X!=Y);
		int countX = 0;
		int countY = 0;
		int fixedArray [] = new int[length];
		for(int i = 0 ; i < length ; i++){
			if((i>0 && arr[i]==X && arr[i-1] == X) || (i==length-1 && arr[i]==X)){
				assert(false);
			}
			if(arr[i] == X){
				countX++;
			}
			if(arr[i] == Y){
				countY++;
			}
		}
		assert(countX==countY);
		int indexOfY [] = new int[length];
		int j = 0;
		for(int i = 0 ; i < length ; i++){
			if(arr[i] == Y){
				if(i>0 && arr[i-1] == X){
					continue;
				}
				indexOfY[j] = i;
				j++;
			}
		}
		int k = 0;
		for(int i = 0 ; i < length-1 ; i++) {
			fixedArray[i] = arr[i];
			if(arr[i] == X && arr[i+1] != Y){
				fixedArray[i+1] = arr[indexOfY[k]];
				fixedArray[indexOfY[k]] = arr[i+1];
				k++;
				i++;
			}
		}
		return fixedArray;
	}
}

