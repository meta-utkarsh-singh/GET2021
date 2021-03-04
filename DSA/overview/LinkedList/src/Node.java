/**
 * 
 * @author utkarsh.singh_metacu
 * 
 * Represents node of a Linked list
 */
public class Node {
	private int value;
	private Node next;
	
	Node(int value){
		this.value = value;
		this.next = null;
	}
	 /**
	  * 
	  * @return getter for value
	  */
	public int getValue(){
		return this.value;
	}
	/**
	 * 
	 * @return getter for next
	 */
	public Node getNext(){
		return this.next;
	}
	/**
	 * 
	 * @param value the value to be set for node
	 */
	public void setValue(int value){
		this.value = value;
	}
	/**
	 * 
	 * @param next pointer to next node
	 */
	public void setNext(Node next){
		this.next = next;
	}
}
