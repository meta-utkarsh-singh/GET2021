package com.dictionary;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestBSTDictionary {

	@Test
	public void testConstructor() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		List<Node> listOfKeyValue = d.getSorted();
		String [] ans = {"abcd","lmno"};
		for(int i = 0 ; i < 2 ; i++){
			assertEquals(0, ans[i].compareTo(listOfKeyValue.get(i).getValue()));
		}
	}
	@Test
	public void testAdd() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz");
		List<Node> listOfKeyValue = d.getSorted();
		String [] ans = {"xyz","abcd","lmno"};
		for(int i = 0 ; i < 3 ; i++){
			assertEquals(0, ans[i].compareTo(listOfKeyValue.get(i).getValue()));
		}
	}
	@Test
	public void testGetValue() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz");
		assertEquals("abcd", d.getValue("1"));
	}
	@Test
	public void testGetValueFail() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz");
		assertEquals("Key Not Found", d.getValue("5"));
	}
	@Test
	public void testGetSortedBetween() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz");
		d.add("3","kkk");
		List<Node> listOfKeyValue = d.getSortedBetween("1","3");
		String [] ans = {"abcd","lmno","kkk"};
		for(int i = 0 ; i < 3 ; i++){
			assertEquals(0, ans[i].compareTo(listOfKeyValue.get(i).getValue()));
		}
	}
	@Test
	public void testDelete() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz");
		d.add("3","kkk");
		d.delete("1");
		assertEquals("lmno",d.getRoot().getValue());
	}
}
