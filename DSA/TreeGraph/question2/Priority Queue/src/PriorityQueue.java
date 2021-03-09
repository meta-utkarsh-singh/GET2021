public class PriorityQueue {
	private int maxSize = 100;
	private int highestPriority = 0;
	private int lastIndex = 0;
	private Item arr[] = new Item[100];
	
	/**
	 * 
	 * @param item item to be added to queue
	 * @return -1 if queue is full
	 * 			1 otherwise
	 */
	public int add(Item item){
		if(this.lastIndex >= maxSize){
			return -1;
		}
		this.arr[this.lastIndex] = item;
		if(item.getPriority() >= highestPriority){
			highestPriority = item.getPriority();
		}
		this.lastIndex++;
		return 1;
	}
	/**
	 * 
	 * @return item with highest priority
	 */
	public Item getHighesPriority(){
		int highest = 1000;
		Item highestItem = new Item(0,0);
		int i = 0 ;
		while(this.arr[i] != null && i < maxSize){
			if(highest >= this.arr[i].getPriority()){
				highest = this.arr[i].getPriority();
				highestItem = this.arr[i];
			}
			i++;
		}
		return highestItem;
	}
	/**
	 * 
	 * @return 1 if item with highest priority is
	 * 		   deleted successfully.
	 * 		   -1 if queue is empty.
	 */
	public int deleteHighestPriority(){
		if(arr[0] == null){
			return -1;
		}
		Item[] deleteList = new Item[this.lastIndex - 1];
		Item highestPriority = this.getHighesPriority();
		for(int i = 0 ; i < this.lastIndex ; i++) {
			if(this.arr[i].getPriority() == highestPriority.getPriority()){
				continue;
			}
			deleteList[i] = (this.arr[i]);
		}
		this.lastIndex = this.lastIndex - 1;
		arr = deleteList;
		return 1;
	}
}

