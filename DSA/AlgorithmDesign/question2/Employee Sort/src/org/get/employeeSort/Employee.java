package org.get.employeeSort;

public class Employee {
	private String name;
	private int age;
	private int salary;
	
	Employee(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
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
	 * @return getter for age
	 */
	public int getAge(){
		return this.age;
	}
	/**
	 * 
	 * @return getter for salary
	 */
	public int getSalary(){
		return this.salary;
	}
}
