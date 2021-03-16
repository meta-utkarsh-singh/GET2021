package com.get.zoomanagement;

public abstract class Animal {
	private String name;
	private int age;
	private int weight;
	private int id;
	private static int idCount = 0;

	Animal(String name, int age, int weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
		Animal.idCount++;
		this.id = idCount;
	}
	/**
	 * 
	 * @return getter for animal name
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
	 * @return getter for weight
	 */
	public int getWeight(){
		return this.weight;
	}
	/**
	 * 
	 * @return id of the animal
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * 
	 * @return category of animal
	 */
	abstract String getCategory();
	/**
	 * 
	 * @return sound made by the animal
	 */
	abstract String getSound();
	/**
	 * 
	 * @return true if animal can fly,
	 * 		   false otherwise
	 */
	abstract boolean canFly();
	/**
	 * For example: Lion, Sparrow
	 * @return breed of animal
	 */
	abstract String getBreed();
}
