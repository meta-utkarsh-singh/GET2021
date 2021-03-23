package com.dictionary;
import java.util.*;

public interface Dictionary {
	/**
	 * 
	 * @param key key for key value pair to be added
	 * @param value value for key value pair to be added
	 */
	void add(String key, String value);
	/**
	 * 
	 * @param key key for key value pair to be deleted
	 */
	Node delete(String key);
	/**
	 * 
	 * @param key key for which value needs to be found
	 * @return value corresponding to key
	 */
	String getValue(String key);
	/**
	 * 
	 * @return list of key value pair in sorted order
	 */
	List<Node> getSorted();
	/**
	 * 
	 * @param k1 lower bound for key
	 * @param k2 upper bound for key
	 * @return list of sorted key value pair between k1 and k2
	 */
	List<Node> getSortedBetween(String k1, String k2);
}