import static org.junit.Assert.*;

import org.junit.Test;


public class TestKnightTour {

	@Test
	public void test1() {
		int arr[][] = {{0,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
		int noOfMoves = 1;
		int dimension = 4;
		int row = 0;
		int col = 0;
		KnightTour kt = new KnightTour(arr, dimension);
		assertEquals(false, kt.knightTour(arr, noOfMoves, row, col, dimension));
	}
	@Test
	public void test2() {
		int arr[][] = {{-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,0,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1}};
		int noOfMoves = 1;
		int dimension = 8;
		int row = 3;
		int col = 3;
		KnightTour kt = new KnightTour(arr, dimension);
		assertEquals(true, kt.knightTour(arr, noOfMoves, row, col, dimension));
	}
	
}
