import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TestSparseMatrix {

	@Test
	public void testTranspose() {
		Pair p1 = new Pair(0,5);
		Pair p2 = new Pair(1,7);
		Pair p3 = new Pair(2,6);
		ArrayList<Pair> col = new ArrayList<Pair>();
		col.add(p1);
		col.add(p2);
		col.add(p3);
		List<ArrayList<Pair>> matrix = new ArrayList<ArrayList<Pair>>();
		matrix.add(0,col);
		int matrixArr[][] = {{5,7,2},{0,0,0},{0,0,0}};
		SparseMatrix sparseMatrix = new SparseMatrix(matrixArr,3);
		List<List<Pair>> transpose = sparseMatrix.transpose();
		for(int i = 0 ; i < 3; i++){
			System.out.println(transpose.get(i).get(0).getValue()+ " " + transpose.get(i).get(0).getIndex());
			assertTrue(sparseMatrix.getMatrix().get(0).get(i).getValue() == transpose.get(i).get(0).getValue());
		}
	}
	@Test
	public void testIsSymmetric(){
		int matrixArr[][] = {{5,0,0},{0,7,0},{0,0,6}};
		SparseMatrix sparseMatrix = new SparseMatrix(matrixArr,3);
		assertTrue(sparseMatrix.isSymmetric());
	}
	@Test 
	public void testAdd(){
		ArrayList<Pair> resultCol1 = new ArrayList<Pair>();
		ArrayList<Pair> resultCol2 = new ArrayList<Pair>();
		ArrayList<Pair> resultCol3 = new ArrayList<Pair>();
		resultCol1.add(new Pair(0,10));
		resultCol1.add(new Pair(1,8));
		resultCol2.add(new Pair(1,14));
		resultCol3.add(new Pair(2,12));
		List<List<Pair>> result = new ArrayList<List<Pair>>();
		result.add(0,resultCol1);
		result.add(1,resultCol2);
		result.add(2,resultCol3);
		int matrixArr1[][] = {{5,0,0},{0,7,0},{0,0,6}};
		int matrixArr2[][] = {{5,8,0},{0,7,0},{0,0,6}};
		SparseMatrix sparseMatrix = new SparseMatrix(matrixArr1, 3);
		List<List<Pair>> add = sparseMatrix.add(matrixArr2);
		for(int i = 0 ; i < add.size() ; i++){
			for(int j = 0 ; j < add.get(i).size() ; j++){
				assertEquals(result.get(i).get(j).getIndex(), add.get(i).get(j).getIndex());
				assertEquals(result.get(i).get(j).getValue(), add.get(i).get(j).getValue());
			}
		}
	}
	@Test 
	public void testMultiply(){
		ArrayList<Pair> resultCol1 = new ArrayList<Pair>();
		resultCol1.add(new Pair(0,29));
		List<ArrayList<Pair>> result = new ArrayList<ArrayList<Pair>>();
		result.add(0,resultCol1);
		int matrixArr1[][] = {{2,0,0},{3,0,0},{4,0,0}};
		int matrixArr2[][] = {{2,3,4},{3,0,0},{4,0,0}};
		SparseMatrix sparseMatrix = new SparseMatrix(matrixArr1, 3);
		List<List<Pair>> multiply = sparseMatrix.multiply(matrixArr2);
		assertEquals(multiply.get(0).get(0).getValue(),29);
	}

}
