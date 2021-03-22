import java.util.*;	

public class EmpCollection {
	private Set<Employee> empList;
	private List<Employee> sorted = new ArrayList<Employee>();
	EmpCollection(){
		empList = new HashSet<Employee>();
	}
	/**
	 * @param e employee to be added
	 * @return true if employee added successfully
	 * 		   false otherwise
	 */
	public boolean add(Employee e){
		empList.add(e);
	}
	/**
	 * 
	 * @return list of employee sorted by id
	 */
	public Set<Employee> sortNatural(){
		for(Employee e : this.empList) {
			sorted.add(e);
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
		for(Employee e : this.empList) {
			sorted.add(e);
		}
		Collections.sort(sorted, new SortByName());
		return sorted;
	}
}
