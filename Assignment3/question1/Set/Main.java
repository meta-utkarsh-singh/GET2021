import java.util.*;

final class intSet {
	final private int set [];
	final private int checkRepeat[];
	final private int maxSize = 1001;
	final private int complementSet[] = new int[maxSize];
	/**
	 * 
	 * @param arr set of integer
	 * @param value the value to which the array elements are set to.
	 * sets the value of all elements of array to value.
	 */
	private void setValue(int arr[], int value){
		for(int i = 0 ; i < arr.length ; i++) {
			arr [i] = value;
		}
	}
	/**
	 * 
	 * @param inpArr
	 * 			requires: input array of numbers with values in 1-1000
	 * creates a set from the given array
	 */
	intSet(int inpArr[]){
		int length = inpArr.length;
		int index = 0;
		this.set = new int[maxSize];
		this.checkRepeat = new int[maxSize];
		setValue(this.set, 0);
		setValue(this.checkRepeat, 0);
		for(int i = 1 ; i < maxSize ; i++){
			complementSet[i] = i;
		}
		for(int i = 0 ; i < length ; i++){
			if(this.checkRepeat[inpArr[i]] == 0){
				this.set[index] = inpArr[i];
				index++;
			}
			this.checkRepeat[inpArr[i]] = 1;
		}
	}
	/**
	 * 
	 * @return
	 * 		return: the size of the set
	 */
	public int size(){
		int length = 0;
		for(int i = 0 ; i < maxSize ; i++){
			if(this.set[i]!=0){
				length++;
				continue;
			}
			break;
		}
		return length;
	}
	/**
	 * 
	 * @param checkMember integer to be searched in set.
	 * @return true if the integer is found, false in all other cases.
	 */
	public boolean isMember(int checkMember){
		for(int i = 0 ; i < this.set.length ; i++){
			if(this.set[i] == checkMember){
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param s1 intSet with values between 1-1000.
	 * @param s2 intSet with values between 1-1000.
	 * @return intSet containing elements 
	 * 		   present in s1 union s2.
	 */
	public intSet union(intSet s1, intSet s2){
		int unionSet[] = new int[maxSize];
		int checkSet1[] = new int[maxSize];
		int checkSet2[] = new int[maxSize];
		setValue(checkSet1 , 0);
		setValue(checkSet2 , 0);
		for(int i = 0 ; i < maxSize; i++){
			checkSet1[s1.set[i]] = 1;
			checkSet2[s2.set[i]] = 1;
		}
		for(int i = 1 ; i < maxSize ; i++){
			if(checkSet1[i] == 1 && checkSet2[i] == 1){
				unionSet[i] = i;
				continue;
			}
			if(checkSet1[i] == 1)
				unionSet[i] = i;
			if(checkSet2[i] == 1)
				unionSet[i] = i;
		}
		intSet union = new intSet(unionSet);
		return union;
	}
	/**
	 * 
	 * @return the complement of intSet object
	 * 		   for union set [1,1000]
	 */
	public intSet getComplement(){
		intSet s = this;
		for(int i = 0 ; i < s.size() ; i++){
			this.complementSet[s.set[i]] = 0;
		}
		int sizeOfComplement = maxSize-s.size();
		int complementFinal[] = new int[sizeOfComplement];
		int index = 0;
		for(int i = 0 ; i < maxSize ; i++){
			if(this.complementSet[i] != 0){
				complementFinal[index] = complementSet[i];
				index++;
			}
		}
		intSet complement = new intSet(complementFinal);
		return complement;
	}
	/**
	 * 
	 * @param s set that is to be found as a subset of the object
	 * @return true if s is a subset of the 
	 * 		   object on which the function is called
	 */
	public boolean isSubset(intSet s){
		intSet unionOfSet = union(this, s);
		if(Math.max(this.size(), s.size()) != unionOfSet.size()){
			return false;
		}
		if(this.size() > s.size()){
			for(int i = 0 ; i < this.size() ; i++){
				if(this.set[i] != unionOfSet.set[i]){
					return false;
				}
			}
		}
		else if(this.size() < s.size()){
			for(int i = 0 ; i < s.size() ; i++){
				if(s.set[i] != unionOfSet.set[i]){
					return false;
				}
			}
		}
		return true;
	}
	
}

public class Main {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,4,5};
		intSet s = new intSet(arr);
		System.out.println(s.size());
		System.out.println(s.getComplement().size());
	}

}
