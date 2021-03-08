/**
 * 
 * @author utkarsh.singh_metacu
 * represents each item in a priority queue
 */
public class Item {
	private int value;
	private int priority;
	
	Item(int value, int priority){
		this.value = value;
		this.priority = priority;
	}
	
	/**
	 * 
	 * @return value of current item
	 */
	public int getValue(){
		return this.value;
	}
	/**
	 * 
	 * @return priority of current item
	 */
	public int getPriority(){
		return this.priority;
	}
}
