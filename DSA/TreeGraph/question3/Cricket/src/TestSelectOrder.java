import static org.junit.Assert.*;

import org.junit.Test;


public class TestSelectOrder {

	@Test
	public void test() {
		int noOfBalls = 3;
		int arr[] = {5, 7, 3, 4, 8, 6, 1};
		int noOfBallers = arr.length;
		SelectOrder so = new SelectOrder();
		int ansArr[] = so.getOrder(arr, noOfBalls, noOfBallers);
		for(int i = 0 ; i < 3 ; i++){
			System.out.println(ansArr[i]);
		}
		assertEquals(ansArr[0], 8);
		assertEquals(ansArr[1], 7);
		assertEquals(ansArr[2], 6);
	}

}
