
public class Nqueen {
	private int arr[][];
	Nqueen(int arr[][]){
		this.arr = arr;
	}
	/**
	 * 
	 * @param arr representation of n*n board
	 * @param row the present row at which we are trying to place the queen
	 * @param dimension dimension of board
	 * @return 1 if it is safe to place a queen on that square,
	 * 		   0 in all other cases
	 */
	private int isSafe(int arr[][], int row, int col, int dimension){
		int rowCount = row;
		for(int i = col; i < dimension && rowCount < dimension ; i++){
			if(this.arr[rowCount][i] == 1){
				return 0;
			}
			rowCount++;
		}
		rowCount = row;
		for(int i = col; i >= 0 && rowCount >= 0 ; i--){
			if(this.arr[rowCount][i] == 1){
				return 0;
			}
			rowCount--;
		}
		for(int i = 0; i < dimension; i++){
			if(this.arr[row][i] == 1){
				return 0;
			}
		}
		for(int i = 0; i < dimension; i++){
			if(this.arr[i][col] == 1){
				return 0;
			}
		}
		rowCount = row;
		for(int i = col; i < dimension && rowCount >= 0 ; i++){
			if(this.arr[rowCount][i] == 1){
				return 0;
			}
			rowCount--;
		}
		rowCount = row;
		for(int i = col ; i > 0  && rowCount < dimension ; i--){
			if(this.arr[rowCount][i] == 1){
				return 0;
			}
			rowCount++;
		}
		return 1;
	}
	/**
	 * 
	 * @param arr array representing the board of given dimension
	 * @param startRow starting row for placing queens
	 * @param dimension dimension of board
	 * @return true if it is possible to place the queens on board
	 * 		   false in all other cases
	 */
	public boolean findNqueen(int arr[][], int startRow, int dimension){
		if(startRow>=dimension){
			return true;
		}
		for(int i = 0 ; i < dimension ; i++){
			if(isSafe(arr, startRow, i, dimension) == 1){
				this.arr[startRow][i] = 1;
				if(findNqueen(this.arr, (startRow)+1, dimension)){
					return true;
				}
				this.arr[startRow][i] = 0;
			}
			
		}
		return false;
	}
	/**
	 * 
	 * @param arr array representing the board of given dimension
	 * @param startRow starting row for placing queens
	 * @param dimension dimension of board
	 * @return true if it is possible to place the queens on board
	 * 		   false in all other cases
	 * Note: Used for printing the board
	 */
	public boolean showBoard(int arr[][], int startRow, int dimension){
		if(findNqueen(this.arr, startRow, dimension)){
			for(int i = 0; i < dimension; i++){
				for(int j = 0 ; j < dimension ; j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			return true;
		}
		return false;
	}
}
