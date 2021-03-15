package com.dictionary;

public class Node {
	private String key;
	private String value;
	private Node left;
	private Node right;
	
	Node(String key, String value){
		this.right = null;
		this.left = null;
		this.key = key;
		this.value = value;
	}
	/**
	 * 
	 * @return getter for key
	 */
	public String getKey(){
		return this.key;
	}
	/**
	 * 
	 * @return getter for value
	 */
	public String getValue(){
		return this.value;
	}
	/**
	 * 
	 * @return getter for left child
	 */
	public Node getLeft(){
		return this.left;
	}
	/**
	 * 
	 * @return getter for right child
	 */
	public Node getRight(){
		return this.right;
	}
	/**
	 * Setter for right child
	 * @param r node to which right points to
	 */
	public void setNodeRight(Node r){
		this.right = r;
	}
	/**
	 * Setter for left child
	 * @param l node to which left points to
	 */
	public void setNodeLeft(Node l){
		this.left = l;
	}
	/**
	 * 
	 * @param key setter for key
	 */
	public void setKey(String key){
		this.key = key;
	}
	/**
	 * 
	 * @param value setter for value;
	 */
	public void setValue(String value){
		this.value = value;
	}
}
