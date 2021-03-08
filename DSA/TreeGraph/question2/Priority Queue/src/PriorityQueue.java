import java.util.*;

public class PriorityQueue {
	private int maxSize = 100;
	private int highestPriorityIndex = 0;
	private int highestPriority = 0;
	private int lastIndex = 0;
	private Item arr[] = new Item[100];
	
	public int add(Item item){
		if(lastIndex >= maxSize){
			return -1;
		}
		this.arr[lastIndex] = item;
		if(item.getPriority() >= highestPriority){
			highestPriority = item.getPriority();
			highestPriorityIndex = this.lastIndex;
		}
		lastIndex++;
		return 1;
	}
	public Item getHighesPriority(){
		int highest = 0;
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
	public int deleteHighestPriority(){
		List<Item> deleteList = new ArrayList<Item>();
		for(int i = 0 ; i < this.lastIndex ; i++) {
			if(i == this.highestPriorityIndex){
				continue;
			}
			deleteList.add(this.arr[i]);
		}
		Object deleteArray[] = deleteList.toArray();
		return 1;
	}
}
