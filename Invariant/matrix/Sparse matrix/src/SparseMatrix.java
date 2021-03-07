import java.util.*;

/**
 * 
 * @author utkarsh.singh_metacu
 * represents a sparse matrix
 * NOTE: It is considered that we store
 * 		 the matrix in sorted order of rows and column, since 
 * 		 user always provides the full matrix with zeros, so the
 * 		 normal order is sorted.
 */
public class SparseMatrix {
	private List<ArrayList<Pair>> matrix = new ArrayList<ArrayList<Pair>>();
	private int dimension = 0;
	SparseMatrix(List<ArrayList<Pair>>  matrix, int dimension){
		this.matrix = matrix;
		this.dimension = dimension;
	}
	/**
	 * 
	 * @return getter for matrix
	 */
	public List<ArrayList<Pair>> getMatrix(){
		return this.matrix;
	}
	/**
	 * 
	 * @return list of arraylist containing non-zero 
	 * 		   elements of transpose matrix of current object
	 */
	public List<ArrayList<Pair>> transpose(){
 		List<ArrayList<Pair>> transposeMatrix = new ArrayList<ArrayList<Pair>>();
		for(int i = 0 ; i < this.matrix.size() ; i++){
			if(this.matrix.get(i) != null){
				for(int j = 0 ; j < matrix.get(i).size() ; j++){
					if(transposeMatrix.size() <= this.matrix.get(i).get(j).getIndex()){
						ArrayList<Pair> firstInsertion = new ArrayList<Pair>();
						Pair complementValue = new Pair(i , this.matrix.get(i).get(j).getValue());
						firstInsertion.add(complementValue);
						transposeMatrix.add(this.matrix.get(i).get(j).getIndex(), firstInsertion);
					}
					else {
						Pair complementValue = new Pair(i,this.matrix.get(i).get(j).getValue());
						transposeMatrix.get(this.matrix.get(i).get(j).getIndex()).add(complementValue);
					}
				}
			}
		}
		return transposeMatrix;
	}
	/**
	 * 
	 * @return true of the matrix is symmetric,
	 * 		   false otherwise
	 */
	public boolean isSymmetric(){
		List<ArrayList<Pair>> transpose = this.transpose();
		for(int i = 0 ; i < dimension ; i++){
			if((transpose.get(i) == null && matrix.get(i) != null) || 
					(transpose.get(i) != null && matrix.get(i) == null) ||
					(transpose.get(i).size() != matrix.get(i).size())){
				return false;
			}
			for(int j = 0 ; j < matrix.get(i).size() ; j++) {
				if(matrix.get(i).get(j).getValue() != transpose.get(i).get(j).getValue()){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 
	 * @param mat matrix to be added to current object
	 * @return list of arraylist consisting of non-zero
	 * 		   elements present in the sum of two lists
	 */
	public List<ArrayList<Pair>> add(List<ArrayList<Pair>> mat){
		List<ArrayList<Pair>> addMatrix = new ArrayList<ArrayList<Pair>>();
		for(int i = 0 ; i < Math.max(this.matrix.size(), mat.size());i++){
			if(i < Math.min(this.matrix.size(), mat.size())){
				int colSize = Math.max(this.matrix.get(i).size(), mat.get(i).size());
				for(int j = 0 ; j < colSize ; j++){
					if(j >= this.matrix.get(i).size() && mat.get(i).size() != 0){
						if(addMatrix.size() <= i){
							Pair addResult = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue());
							ArrayList<Pair>firstList = new ArrayList<Pair>();
							firstList.add(addResult);
							addMatrix.add(i, firstList);
						}
						else{
							Pair addResult = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue());
							addMatrix.get(i).add(addResult);
						}
						continue;
					}
					if(j >= mat.get(i).size() && this.matrix.get(i).size() != 0){
						if(addMatrix.size() <= i){
							Pair addResult = new Pair(this.matrix.get(i).get(j).getIndex(), this.matrix.get(i).get(j).getValue());
							ArrayList<Pair>firstList = new ArrayList<Pair>();
							firstList.add(addResult);
							addMatrix.add(i, firstList);
						}
						else{
							Pair addResult = new Pair(this.matrix.get(i).get(j).getIndex(), this.matrix.get(i).get(j).getValue());
							addMatrix.get(i).add(addResult);
						}
					}
					if(this.matrix.get(i).size() == 0){
						if(addMatrix.size() <= i){
							Pair addResult = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue());
							ArrayList<Pair>firstList = new ArrayList<Pair>();
							firstList.add(addResult);
							addMatrix.add(i, firstList);
						}
						else{
							Pair addResult = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue());
							addMatrix.get(i).add(addResult);
						}
					}
					else if(mat.get(i).size() == 0){
						if(addMatrix.size() <= i){
							Pair addResult = new Pair(this.matrix.get(i).get(j).getIndex(), this.matrix.get(i).get(j).getValue());
							ArrayList<Pair>firstList = new ArrayList<Pair>();
							firstList.add(addResult);
							addMatrix.add(i, firstList);
						}
						else{
							Pair addResult = new Pair(this.matrix.get(i).get(j).getIndex(), this.matrix.get(i).get(j).getValue());
							addMatrix.get(i).add(addResult);
						}
					}
					else if(this.matrix.get(i).get(j).getIndex() == mat.get(i).get(j).getIndex()){
						if(addMatrix.size() <= i){
							Pair addResult = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue()+matrix.get(i).get(j).getValue());
							ArrayList<Pair>firstList = new ArrayList<Pair>();
							firstList.add(addResult);
							addMatrix.add(i, firstList);
						}
						else{
							Pair addResult = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue()+matrix.get(i).get(j).getValue());
							addMatrix.get(i).add(addResult);
						}
					}
					else{
						if(addMatrix.size() <= i){
							Pair addResult1 = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue());
							Pair addResult2 = new Pair(matrix.get(i).get(j).getIndex(), matrix.get(i).get(j).getValue());
							ArrayList<Pair>firstList = new ArrayList<Pair>();
							firstList.add(addResult1);
							firstList.add(addResult2);
							addMatrix.add(i, firstList);
						}
						else{
							Pair addResult1 = new Pair(mat.get(i).get(j).getIndex(), mat.get(i).get(j).getValue());
							Pair addResult2 = new Pair(matrix.get(i).get(j).getIndex(), matrix.get(i).get(j).getValue());
							addMatrix.get(i).add(addResult2);
							addMatrix.get(i).add(addResult1);
						}
					}
				}
			}
			else{
				if(Math.max(this.matrix.size(), mat.size()) == this.matrix.size()){
					addMatrix.set(i, this.matrix.get(i));
				}
				else if(Math.max(this.matrix.size(), mat.size()) == mat.size()){
					addMatrix.set(i, mat.get(i));
				}
			}
			
		}
		return addMatrix;
	}
	/**
	 * 
	 * @param m1 first matrix to be multiplied to the object sparse matrix
	 * @return list of arraylist representing multiplied matrix
	 */
	public List<ArrayList<Pair>> multiply(List<ArrayList<Pair>> m1){
		List<ArrayList<Pair>> multiplyMatrix = new ArrayList<ArrayList<Pair>>();
		List<ArrayList<Pair>> m2Transpose = this.transpose();
		for(int i = 0 ; i < m1.size() ; i++){
			if(m1.get(i) == null){
				continue;
			}
			int indexMoveM1 = 0;
			for(int j = 0 ; j < m2Transpose.size() ; j++){
				if(m2Transpose.get(j) == null){
					continue;
				}
				int sum = 0;
				for(int k = 0 ; k < m2Transpose.get(j).size() ;){
					if(indexMoveM1 >= m1.get(i).size()){
						break;
					}
					if(m1.get(i).get(indexMoveM1).getIndex() < m2Transpose.get(j).get(k).getIndex()){
						indexMoveM1++;
					}
					else  if(m1.get(i).get(indexMoveM1).getIndex() > m2Transpose.get(j).get(k).getIndex()){
						k++;
					}
					else{
						sum+=m1.get(i).get(indexMoveM1).getValue()*m2Transpose.get(j).get(k).getValue();
						indexMoveM1++;
						k++;
					}
				}
				if(multiplyMatrix.size() <= i){
					ArrayList<Pair> firstValue = new ArrayList<Pair>();
					Pair value = new Pair(j,sum);
					firstValue.add(value);
					multiplyMatrix.add(i, firstValue);
				}
				else {
					Pair value = new Pair(j,sum);
					multiplyMatrix.get(i).add(value);
				}
			}
			
		}
		return multiplyMatrix;
	}
}
