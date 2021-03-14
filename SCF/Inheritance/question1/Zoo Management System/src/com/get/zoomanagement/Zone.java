package com.get.zoomanagement;
import java.util.*;

public class Zone {
	private int cageLimit;
	private int zoneId;
	private List<Cage> cageInZone = new ArrayList<Cage>();
	private String supportedType;
	private boolean hasPark;
	
	Zone(int cageLimit, int zoneId, String supportedType, boolean hasPark){
		this.cageLimit = cageLimit;
		this.zoneId = zoneId;
		this.supportedType = supportedType;
		this.hasPark = hasPark;
	}
	/**
	 * 
	 * @return getter for hasPark
	 */
	public boolean getHasPark(){
		return this.hasPark;
	}
	/**
	 * 
	 * @return getter for zoneId
	 */
	public int getZoneId(){
		return this.zoneId;
	}
	/**
	 * 
	 * @return getter for cageLimit
	 */
	public int getCageLimit(){
		return this.cageLimit;
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
	 * @return getter for cageInZone
	 */
	public List<Cage> getCageInZone(){
		return this.cageInZone;
	}
	/**
	 * 
	 * @param c cage to be added to zone
	 * @return -1 if cage type is not supported in give zone
	 * 		   0 if cage limit is reached for given zone
	 * 		   1 if cage is added successfully
	 */
	public int addCage(Cage c){
		if(c.getSupportedType() != this.supportedType){
			return -1;
		}
		if(this.cageInZone.size() >= cageLimit){
			return 0;
		}
		cageInZone.add(c);
		return 1;
	}
}
