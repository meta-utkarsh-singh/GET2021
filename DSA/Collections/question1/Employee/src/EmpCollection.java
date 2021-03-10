import java.util.*;	

public class EmpCollection {
	private List<Employee> empList = new ArrayList<Employee>();
	private List<Employee> sorted = new ArrayList<Employee>();
	/**
	 * 
	 * @param e employee to be added
	 * @return return success message if a new employee is added,
	 * 		   returns failure message otherwise
	 */
	public String add(Employee e){
		if(e==null){
			return "enter valid value";
		}
		for(int i = 0 ; i < empList.size() ; i++){
			if(this.empList.get(i).getEmpId() == e.getEmpId()){
				return "Failed";
			}
		}
		empList.add(e);
		return "Success";
	}
	/**
	 * 
	 * @return list of employee sorted by id
	 */
	public List<Employee> sortNatural(){
		for(int i = 0 ; i < empList.size() ; i++) {
			sorted.add(empList.get(i));
		}
		Collections.sort(sorted, new SortById());
		return sorted;
	}
	/**
	 * 
	 * @return list of employee sorted by name
	 */
	public List<Employee> sortByName(){
		sorted.clear();
		for(int i = 0 ; i < empList.size() ; i++) {
			sorted.add(empList.get(i));
		}
		Collections.sort(sorted, new SortByName());
		return sorted;
	}
}
