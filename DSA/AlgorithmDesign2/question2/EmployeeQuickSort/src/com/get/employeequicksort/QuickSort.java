package com.get.employeequicksort;

public class QuickSort {
	/**
	 * Finds the position of current pivot element.
	 * @param start start of the partition of linked list
	 * @param end end of partition of linked list
	 * @return the position of next pivot element
	 */
	private Node getPivot(Node start, Node end){
		Node pivot = end;
		Node pivotNext = start;
		Node currentSwap = start;
		while(start != end){
			Employee currEmployee = start.getEmployee();
			if(currEmployee.getSalary() > pivot.getEmployee().getSalary()
					|| (currEmployee.getSalary() == pivot.getEmployee().getSalary()
					&& currEmployee.getAge() < pivot.getEmployee().getAge())) {
				pivotNext = currentSwap;
				Employee swap = currentSwap.getEmployee();
				currentSwap.setEmployee(currEmployee);
				start.setEmployee(swap);
				currentSwap = currentSwap.getNext();
			}
			start = start.getNext();
		}
		Employee endEmployee = end.getEmployee();
		pivot.setEmployee(currentSwap.getEmployee());
		currentSwap.setEmployee(endEmployee);
		return pivotNext;
	}
	
	/**
	 * Divided the list on the basis of pivot element
	 * @param start start element for current partition
	 * @param end end element for current partition
	 */
	public void sort(Node start, Node end) {
		if(start == null || end == null || start == end){
			return;
		}
		
		Node pivot = getPivot(start, end);
		sort(start, pivot);
		if(pivot!=null && pivot == start){
			sort(pivot.getNext(), end);
		}
		else if(pivot != null && pivot.getNext()!=null 
				&& pivot.getNext().getNext()!=null){
			sort(pivot.getNext().getNext(), end);
		}
	}
}
