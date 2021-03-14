package com.get.zoomanagement;

public abstract class Mammal extends Animal {
	private String animalType;
	
	Mammal(String name, int age, int weight){
		super(name,age,weight);
		this.animalType = "Mammal";
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
