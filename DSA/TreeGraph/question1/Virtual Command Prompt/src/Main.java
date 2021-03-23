import java.util.*;
public class Main {

	public static void main(String[] args) {
		DirectoryTree dt = new DirectoryTree();
		Scanner in = new Scanner(System.in);
		String input = new String();
		while(true){
			String path = dt.find(dt.getRoot(), dt.getCurrNode().getName());
			System.out.print(path);
			input = in.nextLine();
			if(input.compareTo("ls") == 0){
				dt.ls();
			}
			else if(input.compareTo("bk") == 0){
				if(path.compareTo("/") == 0){
					System.out.println("In root directory");
				}
				else{
					dt.bk();
				}
			}
			else if(input.compareTo("tree") == 0){
				dt.tree();
			}
			else if(input.compareTo("mkdir") == 0 && input.length() <= "mkdir".length() + 1){
				System.out.println("Enter valid directory name");
			}
			else if(input.compareTo("cd") == 0 && input.length() <= "cd".length() + 1){
				System.out.println("Enter valid path");
			}
			else if(input.compareTo("find") == 0 && input.length() <= "find".length() + 1){
				System.out.println("Enter valid name");
			}
			else if(input.length()>"mkdir".length()+1 && input.substring(0,6).compareTo("mkdir ") == 0){
				String dirName = new String();
				for(int i = 6 ; i < input.length() ; i++) {
					dirName = dirName + input.charAt(i);
				}
				dt.mkdir(dirName);
			}
			else if(input.length()>"cd".length()+1 && input.substring(0,3).compareTo("cd ") == 0){
				String pathCD = new String();
				for(int i = 3 ; i < input.length() ; i++) {
					pathCD = pathCD + input.charAt(i);
				}
				dt.cd(pathCD);
			}
			else if(input.length()>"find".length()+1 && input.substring(0,5).compareTo("find ") == 0){
				String dirName = new String();
				for(int i = 5 ; i < input.length() ; i++){
					dirName = dirName + input.charAt(i);
				}
				System.out.println(dt.find(dt.getRoot(), dirName));
			}
			else if(input.compareTo("exit") == 0) {
				break;
			}
			else {
				System.out.println("Enter valid commmand");
			}
		}
	}
}
