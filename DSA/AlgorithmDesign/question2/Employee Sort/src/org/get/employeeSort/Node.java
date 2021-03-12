package org.get.employeeSort;

public class Node {
	private Employee e;
	private Node next;
	
	Node(Employee e){
		this.e = e;
		this.next = null;
	}
	/**
	 * 
	 * @return getter for employee object
	 */
	public Employee getEmployee(){
		return this.e;
	}
	/**
	 * 
	 * @return getter for next node
	 */
	public Node getNext(){
		return this.next;
	}
	/**
	 * 
	 * @param seeter for next
	 */
	public void setNext(Node node){
		this.next = node;
	}
}
