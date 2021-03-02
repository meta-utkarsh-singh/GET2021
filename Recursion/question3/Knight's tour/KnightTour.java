/**
 * 
 * @author utkarsh.singh_metacu
 * 
 * Note: The recursive algorithm used here is not
 * 		 the most efficient algorithm since it runs 
 * 		 in the complexity O(8^(dimension^2)), a better
 *       algorithm to implement a solution to this
 *       problem is Warnsdorff's algorithm, but the 
 *       question requires that the solution be implemented
 *       recursively, therefore I have used this 
 *       algorithm.
 */

public class KnightTour {
	private int arr[][];
	private int dimension;
	private int possibleRow[] = {1, 1, 2, 2, -1, -1, -2, -2};
	private int possibleCol[] = {2, -2, 1, -1, 2, -2, 1, -1};
	KnightTour(int arr[][], int dimension){
		this.arr = arr;
		this.dimension = dimension;
		for(int i = 0; i < this.dimension ; i++){
			for(int j = 0 ; j < this.dimension ; j++){
				this.arr[i][j] = -1;
			}
		}
	}
	/**
	 * 
	 * @param arr represents the chess board
	 * @param row present row to be checked in array
	 * @param col present column to be checked in array
	 * @param dimension dimension of array
	 * @return 1 if it is possible to make a move,
	 * 		   0 in other cases.
	 */
	private int movePossible(int arr[][], int row, int col, int dimension){
		if(row >= 0 && col >= 0 && row < dimension && 
				col < dimension && arr[row][col] == -1){
			return 1;
		}
		return 0;
	}
	/**
	 * 
	 * @param arr array for representing board
	 * @param noOfMoves no of moves made
	 * @param row present row
	 * @param col present column
	 * @param dimension dimension of array
	 * @return true if it is possible to complete the tour,
	 * 		   false in all other cases
	 */
	public boolean knightTour(int arr[][], int noOfMoves, int row, int col, int dimension){
		if(noOfMoves == dimension * dimension){
			return true;
		}
		for(int i = 0 ; i < 8 ; i++){
			int moveRow = row + possibleRow[i];
			int moveCol = col + possibleCol[i];
			if(movePossible(this.arr, moveRow, moveCol, dimension) == 1){
				this.arr[moveRow][moveCol] = noOfMoves;
				if(knightTour(this.arr, noOfMoves+1, moveRow, moveCol, dimension)){
					return true;
				}
				this.arr[moveRow][moveCol] = -1;
			}
		}
		return false;
	}
}
