import java.util.*;

public class CircularQueue {
	private int front = -1;
	private int rear = -1;
	private int maxSize = 0;
	private List<Integer> queue = new ArrayList<Integer>();
	CircularQueue(int maxSize){
		this.maxSize = maxSize;
	}
	/**
	 * 
	 * @return true if queue is empty,
	 * 		   false otherwise.
	 */
	public boolean isEmpty(){
		if(this.front == -1 && this.rear == -1){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return true is queue is full,
	 * 		   false otherwise
	 */
	public boolean isFull(){
		if(this.rear == maxSize-1 && this.front == 0
				|| this.rear == (this.front - 1) % (maxSize-1)){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param value value to be added to queue
	 * @return 1 if operation is successful
	 * 		   -1 otherwise.
	 */
	public int enqueue(int value){
		if(this.isFull()){
			return -1;
		}
		if(this.front == -1){
			this.front = 0;
			this.rear = 0;
			this.queue.add(rear, value);
		}
		else if(this.front != 0 && rear == maxSize - 1){
			this.rear = 0;
			this.queue.set(this.rear, value);
		}
		else {
			this.rear = this.rear + 1;
			if(this.front <= this.rear){
				this.queue.add(value);
			}
			else {
				this.queue.set(this.rear, value);
			}
		}
		return 1;
	}
	/**
	 * 
	 * @return 1 if deletion is successful
	 * 		   -1 otherwise.
	 */
	public int dequeue(){
		if(this.isEmpty()){
			return -1;
		}
		if(this.front == this.rear){
			this.front = -1;
			this.rear = -1;
		}
		else if(this.front == maxSize - 1){
			this.front = 0;
		}
		else {
			this.front = this.front + 1;
		}
		return 1;
	}
}
