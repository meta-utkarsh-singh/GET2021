
public class Main {

	public static void main(String[] args) {
		DirectoryTree dt = new DirectoryTree();
		dt.mkdir("dir1");
		dt.cd("dir1");
		dt.mkdir("dir2");
		dt.bk();
		dt.mkdir("dir2");
		System.out.println(dt.find(dt.getRoot(), "dir3"));
		dt.ls();
		dt.tree();
	}
}
