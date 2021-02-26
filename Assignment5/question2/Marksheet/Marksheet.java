
public class Marksheet {
	/**
	 * 
	 * @param marksheet array of marks in range 1-100,
	 * 				    obtained by each student
	 * @return average marks in a classroom
	 */
	public double average(double marksheet[]){
		double sum = 0;
		double noOfStudent = marksheet.length;
		if(noOfStudent == 0){
			System.out.println("No students found");
			return -1;
		}
		for(int i = 0 ; i < marksheet.length ; i++){
			sum = sum + marksheet[i]; 
		}
		return sum / noOfStudent;
	}
	/**
	 * 
	 * @param marksheet array of marks in range 1-100,
	 * 				    obtained by students
	 * @return maximum marks in the classroom
	 */
	public double maxMarks(double marksheet[]){
		double max = 0;
		for(int i = 0 ; i < marksheet.length ; i++){
			max = Math.max(max , marksheet[i]);
		}
		return max;
	}
	/**
	 * 
	 * @param marksheet array of marks in range 1-100,
	 * 				    obtained by students
	 * @return minimum marks in the classroom
	 */
	public double minMarks(double marksheet[]){
		double min = 100;
		for(int i = 0 ; i < marksheet.length ; i++){
			min = Math.min(min , marksheet[i]);
		}
		return min;
	}
	/**
	 * 
	 * @param marksheet array of marks in range 1-100,
	 * 		  obtained by students
	 * @return percentage of students that passed
	 */
	public double passPercent(double marksheet[]){
		int noOfStudent = marksheet.length;
		double passCount = 0;
		double passPer = 0;
		if(noOfStudent == 0){
			System.out.println("No record found");
			return -1;
		}
		for(int i = 0 ; i < noOfStudent ; i++) {
			if(marksheet[i] >= 40){
				passCount++;
			}
		}
		passPer = (passCount * 100)/noOfStudent;
		return passPer;
	}
}
