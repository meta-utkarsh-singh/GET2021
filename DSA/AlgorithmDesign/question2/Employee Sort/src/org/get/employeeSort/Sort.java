package org.get.employeeSort;
public class Sort {
	/**
	 * 
	 * @param l list to be sorted
	 * @return sorted list based on employee salary and age
	 */
	public LinkedList sort(LinkedList l){
		if(l.getHead() == null){
			System.out.println("Enter valid list");
			return null;
		}
		if(l.getHead().getNext() == null){
			return l;
		}
		Node i = l.getHead();
		LinkedList sorted = new LinkedList();
		while(i != null){
			Node newNode = new Node(new Employee(i.getEmployee()
					.getName(),i.getEmployee().getAge(),
					i.getEmployee().getSalary()));
			if(sorted.getHead() == null && i == l.getHead()){
				sorted.insert(newNode);
				i = i.getNext();
				continue;
			}
			Node j = sorted.getHead();
			while(j.getNext()!=null && j.getEmployee().getSalary() >
					i.getEmployee().getSalary()){
				j=j.getNext();
			}
			if(j.getEmployee().getSalary() == i.getEmployee().getSalary()){
				System.out.println("LinkedList:" + j.getEmployee().getName());
				if(j.getNext() == null){
					if(j.getEmployee().getAge() <= i.getEmployee().getAge()){
						j.setNext(newNode);
					}
					else if(j.getEmployee().getAge() > i.getEmployee().getAge()
							&& j == sorted.getHead()){
						newNode.setNext(j);
						sorted.setHead(newNode);
					}
					else {
						Node k = sorted.getHead();
						while(k.getNext()!=j && k.getNext()!=null){
							k = k.getNext();
						}
						newNode.setNext(k.getNext());
						k.setNext(newNode);
					}
				}
				else {
					if(j.getEmployee().getAge() <= i.getEmployee().getAge()){
						newNode.setNext(j.getNext());
						j.setNext(newNode);
					}
					else {
						Node k = sorted.getHead();
						if(k.getEmployee().getAge() > i.getEmployee().getAge()){
							newNode.setNext(k);
							sorted.setHead(newNode);
							i=i.getNext();
							continue;
						}
						while(k.getNext()!=j && k.getNext()!=null){
							k = k.getNext();
						}
						newNode.setNext(k.getNext());
						k.setNext(newNode);
					}
				}
			}
			else if(j.getNext() == null && j.getEmployee().getSalary() >
					i.getEmployee().getSalary()){
				j.setNext(newNode);
			}
			else if(j.getEmployee().getSalary() <
					i.getEmployee().getSalary()) {
				Node k = sorted.getHead();
				while(k.getNext() != j && k.getNext()!=null){
					k = k.getNext();
				}
				if(k == sorted.getHead() && sorted.getHead().getNext() == null){
					newNode.setNext(k);
					sorted.setHead(newNode);
					i=i.getNext();
					continue;
				}
				newNode.setNext(k.getNext());
				k.setNext(newNode);
			}
			i = i.getNext();
		}
		return sorted;
	}
	
}
