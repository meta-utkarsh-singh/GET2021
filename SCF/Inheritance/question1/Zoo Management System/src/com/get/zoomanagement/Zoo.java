package com.get.zoomanagement;
import java.util.*;

public class Zoo {
	private int maxZones;
	List<Zone> zoneInZoo = new ArrayList<Zone>();
	
	Zoo(int maxZones){
		this.maxZones = maxZones;
	}
	public int addZone(Zone z){
		if(zoneInZoo.size() >= maxZones){
			return -1;
		}
		zoneInZoo.add(z);
		return 1;
	}
	/**
	 * 
	 * @param a animal to be added
	 * @return 1 if successful
	 * 		   0 if no zone with animal type are found 
	 * 		   -1 if no zones exist in zoo
	 */
	public int addAnimal(Animal a){
		if(zoneInZoo.size() == 0){
			return -1;
		}
		for(int i = 0 ; i < zoneInZoo.size() ; i++) {
			if(zoneInZoo.get(i).getSupportedType() == a.getCategory()){
				for(int j = 0 ; j < zoneInZoo.get(i).getCageInZone().size() ; j++){
					if(zoneInZoo.get(i).getCageInZone().get(j).getAnimalSupported() == a.getBreed()
							&& zoneInZoo.get(i).getCageInZone().get(j).getAnimalInCage().size()
								< zoneInZoo.get(i).getCageInZone().
							get(j).getMaxCapacity()){
						zoneInZoo.get(i).getCageInZone().get(j).addAnimal(a);
						return 1;
					}
				}
			}
		}
		return 0;
	}
	/**
	 * 
	 * @param id id of animal to be removed
	 * @return -1 if no zones exist
	 * 		   1 if operation is successful
	 * 		   0 if operation is unsuccessful
	 */
	public int removeAnimal(int id){
		if(zoneInZoo.size() == 0){
			return -1;
		}
		for(int i = 0 ; i < zoneInZoo.size() ; i++){
			for(int j = 0 ; j < zoneInZoo.get(i).getCageInZone().size() ; j++){
				for(int k = 0 ; k < zoneInZoo.get(i).getCageInZone().get(j).getAnimalInCage().size(); k++){
					if(zoneInZoo.get(i).getCageInZone().get(j).getAnimalInCage().get(k).getId() == id){
						zoneInZoo.get(i).getCageInZone().get(j).getAnimalInCage().remove(k);
						return 1;
					}
				}
			}
		}
		return 0;
	}
}
