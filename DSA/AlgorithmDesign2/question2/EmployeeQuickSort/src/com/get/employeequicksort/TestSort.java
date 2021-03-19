package com.get.employeequicksort;

import static org.junit.Assert.*;

import org.junit.Test;

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
		QuickSort sort = new QuickSort();
		sort.sort(emp.getHead(), emp.getTail());
		String expected[] = {"def","kkk","xyz","lmn","abc"};
		Node empItr = emp.getHead();
		for(int i = 0 ; i < expected.length ; i++){
			assertEquals(expected[i], empItr.getEmployee().getName());
			empItr = empItr.getNext();
		}
		emp.viewList();
	}
}
