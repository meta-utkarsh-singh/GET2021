import static org.junit.Assert.*;

import org.junit.Test;


public class TestLinkedList {

	@Test
	/**
	 * tests if insertion is successful
	 * checkArr should equal the values of linkedList
	 */
	public void testInsert() {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		int checkArr[] = {1,2,3};
		Node headLinkedList = linkedList.getHead();
		for(int i = 0 ; i < checkArr.length ; i++){
			assertTrue(checkArr[i] == headLinkedList.getValue());
			headLinkedList = headLinkedList.getNext();
		}
	}
	@Test
	public void testRotate1() {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(8);
		linkedList.insert(9);
		linkedList.printList();
		int left = 2;
		int right = 5;
		int rotateValue = 2;
		int checkArr[] = {1,4,5,2,3,6,7,8,9};
		linkedList.rotate(left, right, rotateValue);
		Node headLinkedList = linkedList.getHead();
		for(int i = 0 ; i < checkArr.length ; i++){
			assertTrue(checkArr[i] == headLinkedList.getValue());
			headLinkedList = headLinkedList.getNext();
		}
	}
	@Test
	public void testRotate2() {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(8);
		linkedList.insert(9);
		int left = 2;
		int right = 3;
		int rotateValue = 1;
		int checkArr[] = {1,3,2,4,5,6,7,8,9};
		linkedList.rotate(left, right, rotateValue);
		Node headLinkedList = linkedList.getHead();
		for(int i = 0 ; i < checkArr.length ; i++){
			assertTrue(checkArr[i] == headLinkedList.getValue());
			headLinkedList = headLinkedList.getNext();
		}
	}
	@Test
	public void testRotate3() {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(8);
		linkedList.insert(9);
		int left = 1;
		int right = 3;
		int rotateValue = 2;
		int checkArr[] = {3,1,2,4,5,6,7,8,9};
		linkedList.rotate(left, right, rotateValue);
		linkedList.printList();
		Node headLinkedList = linkedList.getHead();
		for(int i = 0 ; i < checkArr.length ; i++){
			assertEquals(checkArr[i],headLinkedList.getValue());
			headLinkedList = headLinkedList.getNext();
		}
	}
	@Test
	public void testDetectLoopTrue(){
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(8);
		linkedList.insert(9);
		Node headLinkedList = linkedList.getHead();
		int count = 1;
		while(count < 6){
			headLinkedList = headLinkedList.getNext();
			if(count == 5){
				headLinkedList.setNext(linkedList.getHead());
			}
			count++;
		}
		assertEquals(true,linkedList.detectLoop());
	}
	@Test
	public void testDetectLoopFalse(){
		LinkedList linkedList = new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(8);
		linkedList.insert(9);
		assertEquals(false,linkedList.detectLoop());
	}
}
