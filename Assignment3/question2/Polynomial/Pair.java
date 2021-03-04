
class Pair {
	private int sizeOfPair = 2;
	private int arr[] = new int[sizeOfPair];
	
	/**
	 * 
	 * @param value1 first value of pair
	 * @param value2 second value of pair
	 * the constructor creates a pair of unrelated values
	 */
	Pair(int value1, int value2){
		arr[0] = value1;
		arr[1] = value2;
	}
	/**
	 * 
	 * @return the first value of the pair
	 */
	public int first(){
		return this.arr[0];
	}
	/**
	 * 
	 * @return the second value of pair
	 */
	public int second(){
		return this.arr[1];
	}
	
}
