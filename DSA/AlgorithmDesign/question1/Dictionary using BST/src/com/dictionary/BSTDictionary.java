package com.dictionary;
import org.json.*;

import java.util.List;
import java.util.*;

public class BSTDictionary implements Dictionary {
	private Node root;
	
	BSTDictionary(String JSONKeyValue){
		try {
			JSONObject obj = new JSONObject(JSONKeyValue);
			JSONArray arr = obj.getJSONArray("values");
			for(int i = 0 ; i < arr.length() ; i++){
				String key = arr.getJSONObject(i).getString("key");
				String value = arr.getJSONObject(i).getString("value");
				this.add(key, value);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return getter for root node of BST
	 */
	public Node getRoot(){
		return this.root;
	}
	/**
	 * 
	 * @param key key for value to be inserted
	 * @param value value to be inserted
	 * @param root root of given BST
	 */
	private void addUtil(String key, String value, Node root) {
		if(this.getRoot() == null) {
			Node newNode = new Node(key,value);
			this.root = newNode;
			return;
		}
		if(this.getRoot().getKey().compareTo(key) == 0){
			System.out.println("Key already present");
			return;
		}
		if(root.getLeft() == null && key.compareTo(root.getKey()) < 0){
			Node newNode = new Node(key,value);
			root.setNodeLeft(newNode);
			return;
		}
		if(root.getRight() == null && key.compareTo(root.getKey()) > 0){
			Node newNode = new Node(key,value);
			root.setNodeRight(newNode);
			return;
		}
		if(root.getKey().compareTo(key) < 0){
			addUtil(key, value, root.getRight());
		}
		if(root.getKey().compareTo(key) > 0){
			addUtil(key, value, root.getLeft());
		}
	}
	@Override
	public void add(String key, String value) {
			addUtil(key,value,this.getRoot());
	}
	/**
	 * 
	 * @param node node for which in-order successor needs to be found
	 * @return in-order successor of the given node
	 */
	private Node getInorderSuccessor(Node node){
		while(node.getLeft()!=null){
			node = node.getLeft();
		}
		return node;
	}
	/**
	 * 
	 * @param key key to be deleted
	 * @param root root of BST
	 * @return recursive call to delete the given node
	 */
	private Node deleteUtil(String key, Node root) {
		if(root == null) {
			return root;
		}
		if(root.getKey().compareTo(key) > 0){
			root.setNodeLeft(deleteUtil(key, root.getLeft()));
		}
		else if(root.getKey().compareTo(key) < 0){
			root.setNodeRight(deleteUtil(key,root.getRight()));
		}
		else {
			if(root.getLeft() == null){
				return root.getRight();
			}
			if(root.getRight() == null){
				return root.getLeft();
			}
			root.setKey(getInorderSuccessor(root.getRight()).getKey());
			root.setValue(getInorderSuccessor(root.getRight()).getValue());
			root.setNodeRight(deleteUtil(key,root.getRight()));
		}
		return root;
	}
	@Override
	public Node delete(String key) {
		return deleteUtil(key, this.getRoot());
	}
	/**
	 * 
	 * @param key key for which value is to be found
	 * @param root root of given BST
	 * @return value if key is found,
	 * 		   error message otherwise
	 */
	private String getValueUtil(String key, Node root) {
		if(root == null){
			return "Key Not Found";
		}
		if(root.getKey().compareTo(key) == 0){
			return root.getValue();
		}
		if(root.getKey().compareTo(key) < 0){
			return getValueUtil(key, root.getRight());
		}
		return getValueUtil(key, root.getLeft());
	}
	@Override
	public String getValue(String key) {
		return getValueUtil(key, this.getRoot());
	}
	/**
	 * 
	 * @param root root of given BST
	 * @param listOfKeyValue List that contains sorted order of key values
	 */
	private void getSortedUtil(Node root, List<Node>listOfKeyValue) {
		if(root == null){
			return;
		}
		getSortedUtil(root.getLeft(),listOfKeyValue);
		listOfKeyValue.add(root);
		getSortedUtil(root.getRight(), listOfKeyValue);
	}
	@Override
	public List<Node> getSorted() {
		List<Node> listOfKeyValue = new ArrayList<Node>();
		getSortedUtil(this.getRoot(), listOfKeyValue);
		return listOfKeyValue;
	}
	/**
	 * 
	 * @param k1 lower bound for key
	 * @param k2 upper bound for key
	 * @param root root of given BST
	 * @param sortedList list that stores sorted nodes
	 */
	private void getSortedBetweenUtil(String k1, String k2, Node root, List<Node> sortedList) {
		if(root == null){
			return;
		}
		getSortedBetweenUtil(k1, k2, root.getLeft(), sortedList);
		if(root.getKey().compareTo(k1) >= 0 && root.getKey().compareTo(k2) <= 0){
			
			sortedList.add(root);
		}
		getSortedBetweenUtil(k1, k2, root.getRight(), sortedList);
	}
	@Override
	public List<Node> getSortedBetween(String k1, String k2) {
		List<Node> sortedList = new ArrayList<Node>();
		getSortedBetweenUtil(k1,k2,this.getRoot(), sortedList);
		return sortedList;
	}
	
}