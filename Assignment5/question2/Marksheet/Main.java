
public class Main {

	public static void main(String[] args) {
		double marksheet[] = {68.00 , 75.00 , 96.00};
		Marksheet markS = new Marksheet();
		System.out.println(markS.average(marksheet));
		System.out.println(markS.maxMarks(marksheet));
		System.out.println(markS.minMarks(marksheet));
		System.out.println(markS.passPercent(marksheet));
	}

}