package com.get.zoomanagement;

public class Snake extends Reptile {
	private String animalBreed;
	
	Snake(String name, int age, int weight, String animalBreed){
		super(name,age,weight);
		this.animalBreed = "Snake";
	}
	@Override
	public String getSound(){
		return "Hiss";
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