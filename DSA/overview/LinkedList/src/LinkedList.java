
public class LinkedList {
	private Node head = null;
	
	/**
	 * 
	 * @return getter for head of linked list
	 */
	public Node getHead(){
		return this.head;
	}
	/**
	 * 
	 * @param value value of node to be inserted in linked list
	 */
	public void insert(int value){
		if(this.head == null){
			Node newNode = new Node(value);
			this.head = newNode;
		}
		else {
			Node last = this.head;
			Node newNode = new Node(value);
			while(last.getNext() != null){
				last=last.getNext();
			}
			last.setNext(newNode);
		}
	}
	/**
	 * 
	 * @param left starting index of sublist
	 * @param right ending index of sublist
	 * @param rotateValue number of times rotation needs to be performed
	 */
	public void rotate(int left, int right, int rotateValue){
			if(left == right){
				return;
			}
			Node tillLeft = this.getHead();
			Node tillRight = this.getHead();
			int rValue = rotateValue;
			int count = 1;
			while(true){
				if(count+1 == left){
					tillRight = tillLeft.getNext();
					count++;
					while(count<right){
						tillRight = tillRight.getNext();
						count++;
					}
					System.out.println(rValue);
					while(rValue > 0){
						Node nextToNext = tillLeft.getNext().getNext();
						Node next = tillLeft.getNext();
						tillLeft.getNext().setNext(tillRight.getNext());
						tillRight.setNext(next);
						tillLeft.setNext(nextToNext);
						tillRight = tillRight.getNext();
						rValue = rValue-1;
					}
					System.out.println(count);
					break;
				}
				tillLeft = tillLeft.getNext();
				count++;
			}
	}
	/**
	 * prints the given linked list
	 */
	public void printList(){
		Node last = this.getHead();
		while(last != null){
			System.out.print(last.getValue() + " ");
			last = last.getNext();
		}
		System.out.println();
	}
}
