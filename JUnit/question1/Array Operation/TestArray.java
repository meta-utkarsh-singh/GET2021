import static org.junit.Assert.*;

import org.junit.Test;


public class TestArray {

	@Test
	public void testMaxMirror1(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,4};
		int maxMirror = arrOp.maxMirror(testArr1);
		assertEquals(1,maxMirror);
	}
	@Test
	public void testMaxMirror2(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,4,5,6,7,4,3,1,7,6,5,2,1};
		int maxMirror = arrOp.maxMirror(testArr1);
		assertEquals(3,maxMirror);
	}
	@Test
	public void testMaxMirror3(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,4,3,2,1};
		int maxMirror = arrOp.maxMirror(testArr1);
		assertEquals(7,maxMirror);
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testMaxMirror4(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = new int[0];
		int maxMirror = arrOp.maxMirror(testArr1);
	}
	@Test
	public void testNumberOfClumps1(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,4};
		int clumps = arrOp.numberOfClumps(testArr1);
		assertEquals(0,clumps);
	}
	@Test
	public void testNumberOfClumps2(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,4,2,2,4,2,2,4,3,3};
		int clumps = arrOp.numberOfClumps(testArr1);
		assertEquals(3,clumps);
	}
	@Test
	public void testNumberOfClumps3(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,4,2,2,4,2,2,4,3,3};
		int clumps = arrOp.numberOfClumps(testArr1);
		assertEquals(3,clumps);
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testNumberOfClumps4(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = new int[0];
		int clumps = arrOp.numberOfClumps(testArr1);
	}
	@Test
	public void testSplitArray1(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,6};
		int index = arrOp.splitArray(testArr1);
		assertEquals(3,index);
	}
	@Test
	public void testSplitArray2(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {1,2,3,6,5};
		int index = arrOp.splitArray(testArr1);
		assertEquals(-1,index);
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testSplitArray3(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = new int[0];
		int index = arrOp.splitArray(testArr1);
	}
	@Test
	public void testfixXy1(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {3,2,3,3,6,2,4,2,5};
		int testX = 2;
		int testY = 3;
		int ansArr []= {4,2,3,5,6,2,3,2,3};
		int fixedArray[] = arrOp.fixXY(testArr1, testX, testY);
		for(int i = 0 ; i < ansArr.length ; i++){
			assertEquals(ansArr[i],fixedArray[i]);
		}
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testfixXy1(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = new int[0];
		int testX = 2;
		int testY = 3;
		int ansArr []= {4,2,3,5,6,2,3,2,3};
		int fixedArray[] = arrOp.fixXY(testArr1, testX, testY);
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testfixXy2(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {2,3,4};
		int testX = 2;
		int testY = 3;
		int ansArr []= {4,2,3,5,6,2,3,2,3};
		int fixedArray[] = arrOp.fixXY(testArr1, testX, testY);
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testfixXy3(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {2,3,4};
		int testX = 2;
		int testY = 3;
		int fixedArray[] = arrOp.fixXY(testArr1, testX, testY);
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testfixXy4(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {2,2,3};
		int testX = 2;
		int testY = 3;
		int fixedArray[] = arrOp.fixXY(testArr1, testX, testY);
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testfixXy5(){
		ArrOperation arrOp = new ArrOperation();
		int testArr1[] = {2,3,4,3,2};
		int testX = 2;
		int testY = 3;
		int fixedArray[] = arrOp.fixXY(testArr1, testX, testY);
	}
}
