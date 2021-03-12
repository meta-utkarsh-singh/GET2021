
public class Admission {
	private String studentName;
	private String studentCourse;
	
	Admission(String studentName, String studentCourse){
		this.studentName = studentName;
		this.studentCourse = studentCourse;
	}
	/**
	 * 
	 * @return getter for name of student
	 */
	String getStudentName(){
		return this.studentName;
	}
	/**
	 * 
	 * @return getter for course of student
	 */
	String getStudentCourse(){
		return this.studentCourse;
	}
}
