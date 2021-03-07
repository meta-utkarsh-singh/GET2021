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
		SparseMatrix sparseMatrix = new SparseMatrix(matrix,3);
		List<ArrayList<Pair>> transpose = sparseMatrix.transpose();
		for(int i = 0 ; i < 3; i++){
			System.out.println(transpose.get(i).get(0).getValue()+ " " + transpose.get(i).get(0).getIndex());
			assertTrue(sparseMatrix.getMatrix().get(0).get(i).getValue() == transpose.get(i).get(0).getValue());
		}
	}
	@Test
	public void testIsSymmetric(){
		Pair p1 = new Pair(0,5);
		Pair p2 = new Pair(1,7);
		Pair p3 = new Pair(2,6);
		ArrayList<Pair> col1 = new ArrayList<Pair>();
		ArrayList<Pair> col2 = new ArrayList<Pair>();
		ArrayList<Pair> col3 = new ArrayList<Pair>();
		col1.add(p1);
		col2.add(p2);
		col3.add(p3);
		List<ArrayList<Pair>> matrix = new ArrayList<ArrayList<Pair>>();
		matrix.add(0,col1);
		matrix.add(1,col2);
		matrix.add(2,col3);
		SparseMatrix sparseMatrix = new SparseMatrix(matrix,3);
		assertTrue(sparseMatrix.isSymmetric());
	}
	@Test 
	public void testAdd(){
		Pair p1 = new Pair(0,5);
		Pair p2 = new Pair(1,7);
		Pair p3 = new Pair(2,6);
		Pair p4 = new Pair(1,8);
		ArrayList<Pair> col1 = new ArrayList<Pair>();
		ArrayList<Pair> col2 = new ArrayList<Pair>();
		ArrayList<Pair> col3 = new ArrayList<Pair>();
		ArrayList<Pair> col4 = new ArrayList<Pair>();
		ArrayList<Pair> resultCol1 = new ArrayList<Pair>();
		ArrayList<Pair> resultCol2 = new ArrayList<Pair>();
		ArrayList<Pair> resultCol3 = new ArrayList<Pair>();
		resultCol1.add(new Pair(0,10));
		resultCol1.add(new Pair(1,8));
		resultCol2.add(new Pair(1,14));
		resultCol3.add(new Pair(2,12));
		col1.add(p1);
		col2.add(p2);
		col3.add(p3);
		col4.add(p1);
		col4.add(p4);
		List<ArrayList<Pair>> matrix1 = new ArrayList<ArrayList<Pair>>();
		List<ArrayList<Pair>> matrix2 = new ArrayList<ArrayList<Pair>>();
		List<ArrayList<Pair>> result = new ArrayList<ArrayList<Pair>>();
		SparseMatrix sparseMatrix = new SparseMatrix(matrix1, 3);
		matrix1.add(0,col1);
		matrix1.add(1,col2);
		matrix1.add(2,col3);
		matrix2.add(0,col4);
		matrix2.add(1,col2);
		matrix2.add(2,col3);
		result.add(0,resultCol1);
		result.add(1,resultCol2);
		result.add(2,resultCol3);
		List<ArrayList<Pair>> add = sparseMatrix.add(matrix2);
		for(int i = 0 ; i < add.size() ; i++){
			for(int j = 0 ; j < add.get(i).size() ; j++){
				assertEquals(result.get(i).get(j).getIndex(), add.get(i).get(j).getIndex());
				assertEquals(result.get(i).get(j).getValue(), add.get(i).get(j).getValue());
			}
		}
	}
	@Test 
	public void testMultiply(){
		Pair p1 = new Pair(0,2);
		Pair p2 = new Pair(0,3);
		Pair p3 = new Pair(0,4);
		Pair p4 = new Pair(0,2);
		Pair p5 = new Pair(1,3);
		Pair p6 = new Pair(2,4);
		ArrayList<Pair> col1 = new ArrayList<Pair>();
		ArrayList<Pair> col2 = new ArrayList<Pair>();
		ArrayList<Pair> col3 = new ArrayList<Pair>();
		ArrayList<Pair> col4 = new ArrayList<Pair>();
		ArrayList<Pair> resultCol1 = new ArrayList<Pair>();
		resultCol1.add(new Pair(0,29));
		col1.add(p1);
		col2.add(p2);
		col3.add(p3);
		col4.add(p4);
		col4.add(p5);
		col4.add(p6);
		List<ArrayList<Pair>> matrix1 = new ArrayList<ArrayList<Pair>>();
		List<ArrayList<Pair>> matrix2 = new ArrayList<ArrayList<Pair>>();
		List<ArrayList<Pair>> result = new ArrayList<ArrayList<Pair>>();
		SparseMatrix sparseMatrix = new SparseMatrix(matrix1, 3);
		matrix1.add(0,col1);
		matrix1.add(1,col2);
		matrix1.add(2,col3);
		matrix2.add(0,col1);
		matrix2.add(0,col4);
		result.add(0,resultCol1);
		List<ArrayList<Pair>> multiply = sparseMatrix.multiply(matrix2);
		assertEquals(multiply.get(0).get(0).getValue(),29);
	}

}
