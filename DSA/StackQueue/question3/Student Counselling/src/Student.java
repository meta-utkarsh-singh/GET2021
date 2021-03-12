
public class Student {
	private String name;
	private String program[] = new String[5];
	
	Student(String name, String program[]){
		this.name = name;
		this.program = program;
	}
	/**
	 * 
	 * @return getter for name of student
	 */
	String getName(){
		return this.name;
	}
	/**
	 * 
	 * @param index program number to be retrieved
	 * @return getter for program number
	 */
	String getProgram(int index){
		return this.program[index];
	}
}
