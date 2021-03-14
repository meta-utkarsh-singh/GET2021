package com.get.zoomanagement;

public class Lion extends Mammal {
	private String animalBreed;
	
	Lion(String name, int age, int weight){
		super(name,age,weight);
		this.animalBreed = "Lion";
	}
	@Override
	public String getSound(){
		return "Roar";
	}
	@Override
	public boolean canFly(){
		return false;
	}
	/**
	 * 
	 * @return getter for animalBreed
	 */
	public String getBreed(){
		return this.animalBreed;
	}
}
