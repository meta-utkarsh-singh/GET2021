package com.get.employeequicksort;

public class LinkedList {
	private Node head;
	
	LinkedList(){
		this.head = null;
	}
	/**
	 * 
	 * @return getter for head node
	 */
	public Node getHead(){
		return this.head;
	}
	/**
	 * 
	 * @param node setter for head
	 */
	public void setHead(Node node){
		this.head = node;
	}
	/**
	 * 
	 * @return tail node of linked list
	 */
	public Node getTail(){
		Node temp = this.getHead();
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;
	}
	/**
	 * 
	 * @param node node to be inserted at end 
	 * 		  of linked list
	 */
	public void insert(Node node){
		if(head == null){
			head = node;
		}
		else{
			Node iterate = this.getHead();
			while(iterate.getNext() != null){
				iterate = iterate.getNext();
			}
			iterate.setNext(node);
		}
	}
	/**
	 * Method to view list
	 */
	public void viewList(){
		if(head == null){
			assert(false);
		}
		Node iterate = this.getHead();
		while(iterate != null){
			System.out.println(iterate.getEmployee().getName());
			iterate = iterate.getNext();
		}
	}
}
