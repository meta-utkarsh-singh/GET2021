import java.text.SimpleDateFormat;
import java.util.*;
public class Node {
	private String name;
	private List<Node> child;
	private Node parent = null;
	private String creationTime = new String();
	
	Node(String name, Node parent){
		this.name = name;
		this.child = new ArrayList<Node>();
		this.parent = parent;
		this.creationTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
	/**
	 * 
	 * @return name of folder, file
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * 
	 * @param index index at which the child needs to be retrieved
	 * @return Node at the given index
	 */
	public Node getChild(int index){
		return this.child.get(index);
	}
	/**
	 * 
	 * @param add child node to be added
	 */
	public void addChild(Node add){
		this.child.add(add);
	}
	/**
	 * 
	 * @return number of child nodes present
	 */
	public int getChildSize(){
		return this.child.size();
	}
	/**
	 * 
	 * @return getter for parent node
	 */
	public Node getParent(){
		return this.parent;
	}
	/**
	 * 
	 * @return getter for time of creation
	 */
	public String getTime(){
		return this.creationTime;
	}
}

