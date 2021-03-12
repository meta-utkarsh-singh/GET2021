package org.get.employeeSort;
import org.json.*;
public class Sort {
	/**
	 * 
	 * @param l list to be sorted
	 * @return sorted list based on employee salary and age
	 */
	public LinkedList sort(LinkedList l){
		if(l.getHead().getNext() == null){
			return l;
		}
		Node i = l.getHead().getNext();
		while(i.getNext() != null){
			Node j = i.getPrev();
			Node currentNode = i;
			while(j.getPrev() != null && j.getEmployee().getSalary()
					> currentNode.getEmployee().getSalary()){
					j = j.getPrev();
			}
			if(j.getPrev() == null && j.getEmployee().getSalary()
					< currentNode.getEmployee().getSalary()){
				i = i.getNext();
				continue;
			}
			if(j.getEmployee().getSalary() == currentNode.getEmployee().getSalary()){
				System.out.println("J:"+j.getEmployee().getName());
				System.out.println("I:"+i.getEmployee().getName());
				Node temp = new Node(new Employee(i.getEmployee().getName(),
						i.getEmployee().getAge(),i.getEmployee().getSalary()));
				temp.setNext(i.getNext());
				temp.setPrev(i.getPrev());
				if(j.getEmployee().getAge() > i.getEmployee().getAge()){
					if(j.getPrev() != null){
						i.setPrev(j.getPrev());
						i.setNext(j.getNext());
						j.getNext().setPrev(i);
						j.getPrev().setNext(i);
					}
					else {
						i.setPrev(null);
						i.setNext(j.getNext());
						j.getNext().setPrev(i);
						l.setHead(i);
					}
					if(temp.getNext() != null){
						j.setNext(temp.getNext());
						j.setPrev(temp.getPrev());
						temp.getNext().setPrev(j);
						temp.getPrev().setNext(j);
					}
					else{
						j.setNext(null);
						j.setPrev(temp.getPrev());
						temp.getNext().setPrev(j);
					}
				}
				else if(j.getEmployee().getAge() <= currentNode.getEmployee().getAge()){
					System.out.println("J1:"+j.getEmployee().getName());
					System.out.println("I1:"+i.getEmployee().getName());
					j = j.getNext();
					if(j.getPrev() != null){
						i.setPrev(j.getPrev());
						i.setNext(j.getNext());
						j.getNext().setPrev(i);
						j.getPrev().setNext(i);
					}
					else {
						i.setPrev(null);
						i.setNext(j.getNext());
						j.getNext().setPrev(i);
					}
					if(temp.getNext() != null){
						j.setNext(temp.getNext());
						j.setPrev(temp.getPrev());
						temp.getPrev().setNext(j);
						temp.getNext().setPrev(j);
					}
					else{
						j.setNext(null);
						j.setPrev(temp.getPrev());
						temp.getPrev().setNext(j);
					}
				}
				else {
					if(j.getPrev() == null){
						i.setPrev(null);
						i.setNext(j.getNext());
						j.getNext().setPrev(i);
						l.setHead(i);
					}
					else {
						j = j.getNext();
						i.setPrev(j.getPrev());
						i.setNext(j.getNext());
						j.getNext().setPrev(i);
						j.getPrev().setNext(i);
					}
					if(temp.getNext() != null){
						j.setNext(temp.getNext());
						j.setPrev(temp.getPrev());
						temp.getNext().setPrev(j);
						temp.getPrev().setNext(j);
					}
					else{
						j.setNext(null);
						j.setPrev(temp.getPrev());
						temp.getNext().setPrev(j);
					}
				}
			}
			i = j.getNext();
		}
		return l;
	}
	
}
