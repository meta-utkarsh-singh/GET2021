import static org.junit.Assert.*;

import org.junit.Test;


public class testSearch {

	@Test
	public void testLinearSearch1(){
		int arr[] = {1,2,3,4,6,5,7};
		int value = 7;
		Search search = new Search();
		assertEquals(6,search.linearSearch(arr, value));
	}
	@Test
	public void testLinearSearch2(){
		int arr[] = {1,2,3,4,6,5,7};
		int value = 1;
		Search search = new Search();
		assertEquals(0,search.linearSearch(arr, value));
	}
	@Test
	public void testLinearSearch3(){
		int arr[] = {1,2,3,4,6,5,7};
		int value = 3;
		Search search = new Search();
		assertEquals(2,search.linearSearch(arr, value));
	}
	@Test
	public void testLinearSearch4(){
		int arr[] = {1,2,3,4,6,5,7};
		int value = 8;
		Search search = new Search();
		assertEquals(-1,search.linearSearch(arr, value));
	}
	@Test
	public void testBinarySearch1(){
		int arr[] = {1,2,3,4,5,6,7};
		int value = 7;
		Search search = new Search();
		assertEquals(6,search.binarySearch(arr, value, 0, arr.length));
	}
	@Test
	public void testBinarySearch2(){
		int arr[] = {1,2,3,4,5,6,7};
		int value = 1;
		Search search = new Search();
		assertEquals(0,search.binarySearch(arr, value, 0, arr.length));
	}
	@Test
	public void testBinarySearch3(){
		int arr[] = {1,2,3,4,5,6,7};
		int value = 3;
		Search search = new Search();
		assertEquals(2,search.binarySearch(arr, value, 0, arr.length));
	}
	@Test
	public void testBinarySearch4(){
		int arr[] = {1,2,3,4,5,6};
		int value = 8;
		Search search = new Search();
		assertEquals(-1,search.binarySearch(arr, value, 0, arr.length));
	}
}
