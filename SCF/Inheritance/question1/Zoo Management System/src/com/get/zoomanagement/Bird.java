package com.get.zoomanagement;

public abstract class Bird extends Animal {
	private String animalType;
	
	Bird(String name, int age, int weight){
		super(name,age,weight);
		this.animalType = "Bird";
	}
	/**
	 * 
	 * @return true if animal can fly,
	 * 		   false otherwise
	 */
	@Override
	public String getCategory(){
		return this.animalType;
	}
}
