import java.io.File;


public class Main {

	public static void main(String[] args) {
		File college = new File("D:\\college.xlsx");
		File student = new File("D:\\student.xlsx");
		CounsellingProcess cp = new CounsellingProcess();
		cp.getAllocatedProgram(college, student);
	}

}
