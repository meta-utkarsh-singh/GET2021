package com.dictionary;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestBSTDictionary {

	@Test
	public void testConstructor() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		List<Node> listOfKeyValue = new ArrayList<Node>();
		d.getSorted(d.getRoot(), listOfKeyValue);
		String [] ans = {"abcd","lmno"};
		for(int i = 0 ; i < 2 ; i++){
			assertEquals(0, ans[i].compareTo(listOfKeyValue.get(i).getValue()));
		}
	}
	@Test
	public void testAdd() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz",d.getRoot());
		List<Node> listOfKeyValue = new ArrayList<Node>();
		d.getSorted(d.getRoot(), listOfKeyValue);
		String [] ans = {"xyz","abcd","lmno"};
		for(int i = 0 ; i < 3 ; i++){
			assertEquals(0, ans[i].compareTo(listOfKeyValue.get(i).getValue()));
		}
	}
	@Test
	public void testGetValue() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz",d.getRoot());
		assertEquals("abcd", d.getValue("1", d.getRoot()));
	}
	@Test
	public void testGetValueFail() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz",d.getRoot());
		assertEquals("Key Not Found", d.getValue("5", d.getRoot()));
	}
	@Test
	public void testGetSortedBetween() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz",d.getRoot());
		d.add("3","kkk",d.getRoot());
		List<Node> listOfKeyValue = new ArrayList<Node>();
		d.getSortedBetween("1","3",d.getRoot(), listOfKeyValue);
		String [] ans = {"abcd","lmno","kkk"};
		for(int i = 0 ; i < 3 ; i++){
			assertEquals(0, ans[i].compareTo(listOfKeyValue.get(i).getValue()));
		}
	}
	@Test
	public void testDelete() {
		String input = "{\"values\":[{\"key\" : \"1\", \"value\" : \"abcd\"},{\"key\" : \"2\", \"value\" : \"lmno\"}]}";
		BSTDictionary d = new BSTDictionary(input);
		d.add("0","xyz",d.getRoot());
		d.add("3","kkk",d.getRoot());
		d.delete("1", d.getRoot());
		assertEquals("lmno",d.getRoot().getValue());
	}
}
