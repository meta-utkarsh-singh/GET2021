import java.util.*;
public class DirectoryTree {
	private String rootName = "root";
	private Node root = null;
	Node currNode = null;
	DirectoryTree(){
		this.root = new Node(this.rootName, null);
		this.currNode = this.root;
	}
	/**
	 * 
	 * @param name name of the directory to be created
	 */
	public void mkdir(String name){
		Node parentNode = this.currNode;
		for(int i = 0 ; i < currNode.getChildSize() ; i++){
			if(name.compareTo(currNode.getChild(i).getName()) == 0){
				System.out.println("File already present");
				return;
			}
		}
		Node newNode = new Node(name, parentNode);
		currNode.addChild(newNode);
	}
	/**
	 * 
	 * @return getter for root
	 */
	public Node getRoot(){
		return this.root;
	}
	/**
	 * 
	 * @param path path to the target directory
	 */
	public void cd(String path){
		String dir = new String();
		int flag = 0;
		for(int i = 0 ; i < path.length() ; i++){
			flag = 0;
			if(path.charAt(i) == '/' || i+1 == path.length()){
				if(path.charAt(i) != '/' && i+1 == path.length()){
					dir = dir + path.charAt(i);
				}
				for(int j = 0 ; j < currNode.getChildSize() ; j++){
					if(currNode.getChild(j).getName().compareTo(dir) == 0){
						currNode = currNode.getChild(j);
						dir = "";
						flag = 1;
						break;
					}
				}
				if(flag == 0){
					System.out.println("Enter Valid Path");
					return;
				}
				continue;
			}
		    dir = dir + path.charAt(i);
		}
	}
	/**
	 * goes back to immediately previous directory
	 */
	public void bk(){
		if(currNode.getParent() == null){
			System.out.println("Present at root");
			return;
		}
		currNode = currNode.getParent();
	}
	/**
	 * lists directories in current directory
	 */
	public void ls(){
		int i = 0;
		Node iterate = currNode;
		System.out.println(currNode.getName());
		while(i < currNode.getChildSize()){
			iterate = currNode.getChild(i);
			System.out.println("   "+iterate.getName()+" "+iterate.getTime());
			i++;
		}
	}
	/**
	 * 
	 * @param root root of the current object
	 * @param name name of directory to be found
	 * @return true if directory is found,
	 * 		   false otherwise.
	 */
	public boolean find(Node root, String name){
		if(root.getName().compareTo(name) == 0){
			return true;
		}
		for(int i = 0 ; i < root.getChildSize() ; i++){
			return find(root.getChild(i),name);
		}
		return false;
	}
	/**
	 * Prints directory structure
	 */
	public void tree(){
		Queue<Node> bfs = new LinkedList<Node>();
		bfs.add(this.root);
		System.out.println(bfs.peek().getName());
		while(!bfs.isEmpty()){
			for(int i = 0 ; i < bfs.size() ; i++){
				for(int j = 0 ; j < bfs.peek().getChildSize() ; j++){
					System.out.print(bfs.peek().getChild(j).getName()+" ");
					bfs.add(bfs.peek().getChild(j));
				}
				System.out.println();
				bfs.poll();
			}
		}
	}
	public void exit(){
		System.exit(1);
	}
}
