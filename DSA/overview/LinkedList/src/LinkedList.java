
public class LinkedList {
	private Node head = null;
	
	public Node getHead(){
		return this.head;
	}
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
	public void rotate(int left, int right, int rotateValue){
			Node tillLeft = this.head;
			Node tillRight = this.head;
			int rValue = rotateValue;
			int count = 0;
			while(true){
				tillLeft = tillLeft.getNext();
				count++;
				if(count == left-1){
					tillRight = tillLeft.getNext();
					count++;
					while(count!=right){
						tillRight = tillRight.getNext();
					}
					while(rValue != 0){
						tillRight.setNext(tillLeft.getNext());
						tillLeft.setNext(tillLeft.getNext().getNext());
						rValue--;
					}
					break;
				}
			}
	}
}