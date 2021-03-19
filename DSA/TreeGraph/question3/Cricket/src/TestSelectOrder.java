import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TestSelectOrder {

	@Test
	public void test() {
		int noOfBalls = 15;
		int arr[] = {5, 7, 3, 4, 8, 6, 1};
		int expected[] = {8, 7};
		List<Integer> testList = new ArrayList<Integer>();
		List<Integer> expectedList = new ArrayList<Integer>();
		for(int i = 0 ; i < arr.length ; i++) {
			testList.add(arr[i]);
			if(i < expected.length)
				expectedList.add(expected[i]);
		}
		int noOfBallers = arr.length;
		SelectOrder so = new SelectOrder();
		List<Integer> ansArr = so.getOrder(testList, noOfBalls, noOfBallers);
		for(int i = 0 ; i < 2 ; i++){
			assertEquals(expectedList.get(i), ansArr.get(i));
		}
	}
	@Test
	public void testFail1() {
		List<Integer> testList = new ArrayList<Integer>();
		SelectOrder so = new SelectOrder();
		assertEquals(null, so.getOrder(testList, 1, 1));
	}
	@Test
	public void testFail2() {
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		SelectOrder so = new SelectOrder();
		assertEquals(null, so.getOrder(testList, 4, 1));
	}

}
