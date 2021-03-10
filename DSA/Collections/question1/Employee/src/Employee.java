
public class Employee {
	private int empId;
	private String name;
	private String address;
	
	Employee(int empId, String name, String address){
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	/**
	 * 
	 * @return getter for empId
	 */
	public int getEmpId(){
		return this.empId;
	}
	/**
	 * 
	 * @return getter for name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * 
	 * @return getter for address
	 */
	public String getAddress(){
		return this.address;
	}
}
