import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TestEmployee {

	@Test
	public void testAdd() {
		Employee e1 = new Employee(1,"abc", "def");
		EmpCollection ec = new EmpCollection();
		ec.add(e1);
		assertEquals(1,ec.size());
	}
	@Test
	public void testAddFail() {
		Employee e1 = new Employee(1,"abc", "def");
		Employee e2 = new Employee(1,"abc", "def");
		EmpCollection ec = new EmpCollection();
		ec.add(e1);
		assertEquals(1,ec.add(e2).size());
	}
	@Test
	public void testSortNatural() {
		Employee e1 = new Employee(3,"abc", "def");
		Employee e2 = new Employee(1,"abc", "def");
		Employee e3 = new Employee(5,"abc", "def");
		Employee e4 = new Employee(2,"abc", "def");
		Employee e5 = new Employee(4,"abc", "def");
		List<Employee> actualAns = new ArrayList<Employee>();
		actualAns.add(e2);
		actualAns.add(e4);
		actualAns.add(e1);
		actualAns.add(e5);
		actualAns.add(e3);
		EmpCollection ec = new EmpCollection();
		ec.add(e1);
		ec.add(e2);
		ec.add(e3);
		ec.add(e4);
		ec.add(e5);
		List<Employee> result = ec.sortNatural();
		for(int i = 0 ; i < 5 ; i++){
			assertEquals(actualAns.get(i).getEmpId(),result.get(i).getEmpId());
		}
	}
	@Test
	public void testSortByName() {
		Employee e1 = new Employee(3,"bbc", "def");
		Employee e2 = new Employee(1,"dbc", "def");
		Employee e3 = new Employee(5,"abc", "def");
		Employee e4 = new Employee(2,"ebc", "def");
		Employee e5 = new Employee(4,"cbc", "def");
		List<Employee> actualAns = new ArrayList<Employee>();
		actualAns.add(e3);
		actualAns.add(e1);
		actualAns.add(e5);
		actualAns.add(e2);
		actualAns.add(e4);
		EmpCollection ec = new EmpCollection();
		ec.add(e1);
		ec.add(e2);
		ec.add(e3);
		ec.add(e4);
		ec.add(e5);
		List<Employee> result = ec.sortByName();
		for(int i = 0 ; i < 5 ; i++){
			int compare = actualAns.get(i).getName()
						  .compareTo(result.get(i).getName());
			assertEquals(0,compare);
		}
	}
}
