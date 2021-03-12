package org.get.employeeSort;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class TestSort {

	@Test
	public void test() {
		Employee e1 = new Employee("abc",6,1000);
		Employee e2 = new Employee("def",5,2000);
		Employee e3 = new Employee("lmn",3,1000);
		Employee e4 = new Employee("xyz",5,1100);
		Employee e5 = new Employee("kkk",11,1900);
		LinkedList emp = new LinkedList();
		emp.insert(new Node(e1));
		emp.insert(new Node(e2));
		emp.insert(new Node(e3));
		emp.insert(new Node(e4));
		emp.insert(new Node(e5));
		Sort sort = new Sort();
		LinkedList actual = sort.sort(emp);
		List<Employee> expected= new ArrayList<Employee>();
		expected.add(e3);
		expected.add(e1);
		expected.add(e4);
		expected.add(e5);
		expected.add(e2);
		Node iterate = actual.getHead();
		for(int i = 0 ; i < 5 ; i++){
			assertEquals(expected.get(i).getName(),iterate.getEmployee().getName());
			iterate = iterate.getNext();
		}
		actual.viewList();
	}
	@Test
	public void testFail(){
		LinkedList l = new LinkedList();
		Sort sort = new Sort();
		assertEquals(null, sort.sort(l));
	}
}