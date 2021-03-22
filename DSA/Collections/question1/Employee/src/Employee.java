
public class Employee {
	private int empId;
	private String name;
	private String address;
	
	Employee(int empId, String name, String address){
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || obj.getClass()!=this.getClass()){
			return false;
		}
		Employee emp = (Employee) obj;
		return emp.getEmpId() == this.getEmpId();
	}
	@Override 
	public int hashcode(){
		return this.getEmpId();
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
