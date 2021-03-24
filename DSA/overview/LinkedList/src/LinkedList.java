
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
	 * @return present size of linked list
	 */
	public int getSize() {
		Node tempHead = this.getHead();
		int size = 0;
		while(tempHead!=null) {
			size++;
			tempHead = tempHead.getNext();
		}
		return size;
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
			assert(left < right);
			assert(left < this.getSize());
			assert(right < this.getSize());
			if(left == right){
				return;
			}
			Node tillLeft = this.getHead();
			Node tillRight = this.getHead();
			int rValue = rotateValue;
			int count = 1;
			if(left == 1){
				while (count < right){
					tillRight = tillRight.getNext();
					count++;
				}
				while(rValue > 0){
					Node afterRight = tillRight.getNext();
					tillRight.setNext(tillLeft);
					this.head = tillLeft.getNext();
					tillLeft.setNext(afterRight);
					tillRight = tillLeft;
					tillLeft = this.getHead();
					rValue--;
				}
				return;
			}
			while(true){
				if(count+1 == left){
					tillRight = tillLeft.getNext();
					count++;
					while(count<right){
						tillRight = tillRight.getNext();
						count++;
					}
					while(rValue > 0){
						Node nextToNext = tillLeft.getNext().getNext();
						Node next = tillLeft.getNext();
						tillLeft.getNext().setNext(tillRight.getNext());
						tillRight.setNext(next);
						tillLeft.setNext(nextToNext);
						tillRight = tillRight.getNext();
						rValue = rValue-1;
					}
					break;
				}
				tillLeft = tillLeft.getNext();
				count++;
			}
	}
	/**
	 * 
	 * @return true if loop is detect,
	 * 		   false otherwise
	 */
	public boolean detectLoop(){
		Node fastPointer = this.getHead();
		Node slowPointer = this.getHead();
		while(fastPointer.getNext()!=null && fastPointer.getNext().getNext() != null && 
				slowPointer.getNext() != null){
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			if(fastPointer == slowPointer){
				return true;
			}
		}
		return false;
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
