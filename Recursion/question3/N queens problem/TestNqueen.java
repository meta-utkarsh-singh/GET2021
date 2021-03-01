import static org.junit.Assert.*;

import org.junit.Test;


public class TestNqueen {

	@Test
	public void test1() {
		int[][] arr = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int dimension = 4;
		int startRow = 0;
		Nqueen nqueen = new Nqueen(arr);
		assertEquals(true, nqueen.showBoard(arr, startRow, dimension));
	}
	@Test
	public void test2() {
		int[][] arr = {{0,0,0},{0,0,0},{0,0,0}};
		int dimension = 3;
		int startRow = 0;
		Nqueen nqueen = new Nqueen(arr);
		assertEquals(false, nqueen.showBoard(arr, startRow, dimension));
	}
	@Test
	public void test3() {
		int[][] arr = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int dimension = 5;
		int startRow = 0;
		Nqueen nqueen = new Nqueen(arr);
		assertEquals(true, nqueen.showBoard(arr, startRow, dimension));
	}
}
