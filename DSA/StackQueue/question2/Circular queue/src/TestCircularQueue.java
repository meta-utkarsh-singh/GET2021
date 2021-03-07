import static org.junit.Assert.*;

import org.junit.Test;


public class TestCircularQueue {

	@Test
	public void testIsempty() {
		CircularQueue queue = new CircularQueue(5);
		assertEquals(true, queue.isEmpty());
	}
	@Test
	public void testEnqueue1() {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(1, queue.enqueue(5));
	}
	@Test
	public void testEnqueueFail1() {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(-1, queue.enqueue(6));
	}
	@Test
	public void testIsFull() {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(true, queue.isFull());
	}
	@Test
	public void testDequeue() {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(1, queue.dequeue());
	}
	@Test
	public void testEnqueue2() {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		assertEquals(1, queue.enqueue(6));
	}
	@Test
	public void testEnqueueFail2() {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.enqueue(6);
		assertEquals(-1, queue.enqueue(7));
	}
	@Test
	public void testDequeueFail() {
		CircularQueue queue = new CircularQueue(5);
		assertEquals(-1, queue.dequeue());
	}
}
