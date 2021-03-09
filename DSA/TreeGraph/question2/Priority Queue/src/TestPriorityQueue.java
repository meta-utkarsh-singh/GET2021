import static org.junit.Assert.*;

import org.junit.Test;


public class TestPriorityQueue {

	@Test
	public void testAdd() {
		Item item1 = new Item(1,1);
		PriorityQueue pq = new PriorityQueue();
		assertEquals(1, pq.add(item1));
	}
	@Test
	public void testAddFail() {
		PriorityQueue pq = new PriorityQueue();
		for(int i = 0 ; i < 100 ; i++) {
			Item item = new Item(i+1,i+1);
			pq.add(item);
		}
		assertEquals(-1,pq.add(new Item(101,101)));
	}
	@Test
	public void testDeleteFail() {
		PriorityQueue pq = new PriorityQueue();
		assertEquals(-1,pq.deleteHighestPriority());
	}
	@Test
	public void testDelete() {
		Item item1 = new Item(1,2);
		Item item2 = new Item(2,1);
		PriorityQueue pq = new PriorityQueue();
		pq.add(item1);
		pq.add(item2);
		assertEquals(1,pq.deleteHighestPriority());
	}
	@Test
	public void testGetHighestPriority() {
		Item item1 = new Item(1,2);
		Item item2 = new Item(2,3);
		PriorityQueue pq = new PriorityQueue();
		pq.add(item1);
		pq.add(item2);
		assertEquals(2,pq.getHighesPriority().getPriority());
	}
}
