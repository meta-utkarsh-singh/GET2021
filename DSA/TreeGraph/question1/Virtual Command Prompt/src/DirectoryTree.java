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
	 * @return getter for currNode
	 */
	public Node getCurrNode() {
		return this.currNode;
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
		if(currNode.getChildSize() == 0){
			System.out.println("Empty directory");
			return;
		}
		System.out.println(iterate.getChildSize()+" directories found");
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
	 * @return Directory path if found,
	 * 		   error message otherwise.
	 */
	public String find(Node root, String name){
		String path = new String();
		String tempPath = new String();
		Stack<Node> dfs = new Stack<Node>();
		Stack<String> pathDFS = new Stack<String>();
		dfs.push(root);
		path=path+"/root";
		pathDFS.push(path);
		while(!dfs.isEmpty()) {
			if(name.compareTo("root") == 0){
				return pathDFS.peek().toString();
			}
			Node top = dfs.peek();
			path = pathDFS.peek();
			String pathCurr = path;
			dfs.pop();
			pathDFS.pop();
			for(int i = 0 ; i < top.getChildSize() ; i++){
				tempPath = pathCurr+("/")+(top.getChild(i).getName());
				pathCurr = path;
				if(top.getChild(i).getName().compareTo(name) == 0){
					return tempPath.toString();
				}
				else {
					dfs.push(top.getChild(i));
					pathDFS.push(tempPath);
				}
			}
		}
		return "File not found";
	}
	/**
	 * Prints directory structure
	 */
	public void tree(){
		String verticalL = "\u251c";
		String verticalLine = "\u2502";
		String smallL = "\u2514";
		char space = ' ';
		String spaces = Character.toString(space);
		System.out.println(root.getName());
		Stack<Node> dfs = new Stack<Node>();
		Stack<String> spaceDFS = new Stack<String>();
		spaceDFS.push(spaces);
		dfs.push(root);
		int rootChildVisitedCount = 0;
		while(!dfs.isEmpty()){
			Node top = dfs.peek();
			String topSpace = spaceDFS.peek();
			dfs.pop();
			spaceDFS.pop();
			if(top.getParent() == root) {
				System.out.println(verticalL+top.getName());
				rootChildVisitedCount++;
			}
			else if(top!=root) {
				if(rootChildVisitedCount < this.root.getChildSize()){
					System.out.println(verticalLine + topSpace + smallL + top.getName());
				}
				else {
					System.out.println(topSpace + smallL + top.getName());
				}
			}
			topSpace = topSpace + space;
			for(int i = 0 ; i < top.getChildSize() ; i++){
				spaceDFS.push(topSpace);
				dfs.push(top.getChild(i));
			}
		}
	}
	public void exit(){
		System.exit(1);
	}
}

