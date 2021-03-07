
public class Pair {
	private int index = 0;
	private int value = 0;
	
	Pair(int index, int value){
		this.index = index;
		this.value = value;
	}
	int getIndex(){
		return this.index;
	}
	int getValue(){
		return this.value;
	}
	void setIndex(int index){
		this.index = index;
	}
	void setValue(int value){
		this.value = value;
	}
}
