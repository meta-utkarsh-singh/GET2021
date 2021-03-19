package com.get.employeequicksort;

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
	 * Setter for employee
	 * @param e employee value to which e is set.
	 */
	public void setEmployee(Employee e) {
		this.e = e;
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
