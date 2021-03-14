package com.get.zoomanagement;
import java.util.*;

public class Cage {
	private int maxCapacity;
	private String supportedType;
	private String animalSupported;
	private List<Animal> animalInCage = new ArrayList<Animal>();
	
	Cage(int maxCapacity, String animalSupported, String supportedType) {
		this.maxCapacity = maxCapacity;
		this.animalSupported = animalSupported;
		this.supportedType = supportedType;
	}
	/**
	 * 
	 * @return getter for maxCapacity
	 */
	public int getMaxCapacity(){
		return this.maxCapacity;
	}
	/**
	 * 
	 * @return getter for supportedType
	 */
	public String getSupportedType(){
		return this.supportedType;
	}
	/**
	 * 
	 * @return getter for animalInCage
	 */
	public List<Animal> getAnimalInCage(){
		return this.animalInCage;
	}
	/**
	 * 
	 * @param a animal to be added
	 * @return 1 if added successfully
	 * 		   -1 if animal is not supported
	 * 		   0 if cage has reached its max capacity
	 */
	public int addAnimal(Animal a){
		if(!animalSupported.contains(a.getBreed())){
			return -1;
		}
		if(animalInCage.size() == maxCapacity){
			return 0;
		}
		animalInCage.add(a);
		return 1;
	}
	/**
	 * 
	 * @return getter for animalSupported
	 */
	public String getAnimalSupported(){
		return this.animalSupported;
	}
}
