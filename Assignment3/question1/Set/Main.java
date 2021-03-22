

public class Main {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,4,5};
		IntSet s = new IntSet(arr);
		System.out.println(s.size());
		System.out.println(s.getComplement().size());
	}

}
