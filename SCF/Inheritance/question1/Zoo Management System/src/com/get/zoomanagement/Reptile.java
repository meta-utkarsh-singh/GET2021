package com.get.zoomanagement;

public abstract class Reptile extends Animal {
	private String animalType;
	
	Reptile(String name, int age, int weight){
		super(name,age,weight);
		this.animalType = "Reptile";
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
