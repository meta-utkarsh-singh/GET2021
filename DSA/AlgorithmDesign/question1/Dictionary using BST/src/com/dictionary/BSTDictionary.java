package com.dictionary;
import org.json.*;

import java.util.List;

public class BSTDictionary implements Dictionary {
	private Node root;
	
	BSTDictionary(String JSONKeyValue){
		try {
			JSONObject obj = new JSONObject(JSONKeyValue);
			JSONArray arr = obj.getJSONArray("values");
			for(int i = 0 ; i < arr.length() ; i++){
				String key = arr.getJSONObject(i).getString("key");
				String value = arr.getJSONObject(i).getString("value");
				this.add(key, value, root);
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
	@Override
	public void add(String key, String value, Node root) {
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
			add(key, value, root.getRight());
		}
		if(root.getKey().compareTo(key) > 0){
			add(key, value, root.getLeft());
		}
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
	@Override
	public Node delete(String key, Node root) {
		if(root == null) {
			return root;
		}
		if(root.getKey().compareTo(key) > 0){
			root.setNodeLeft(delete(key, root.getLeft()));
		}
		else if(root.getKey().compareTo(key) < 0){
			root.setNodeRight(delete(key,root.getRight()));
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
			root.setNodeRight(delete(key,root.getRight()));
		}
		return root;
	}

	@Override
	public String getValue(String key, Node root) {
		if(root == null){
			return "Key Not Found";
		}
		if(root.getKey().compareTo(key) == 0){
			return root.getValue();
		}
		if(root.getKey().compareTo(key) < 0){
			return getValue(key, root.getRight());
		}
		return getValue(key, root.getLeft());
		
	}

	@Override
	public void getSorted(Node root, List<Node> listOfKeyValue) {
		if(root == null){
			return;
		}
		getSorted(root.getLeft(),listOfKeyValue);
		listOfKeyValue.add(root);
		getSorted(root.getRight(), listOfKeyValue);
	}

	@Override
	public void getSortedBetween(String k1, String k2, Node root, List<Node> sortedList) {
		if(root == null){
			return;
		}
		getSortedBetween(k1, k2, root.getLeft(), sortedList);
		if(root.getKey().compareTo(k1) >= 0 && root.getKey().compareTo(k2) <= 0){
			
			sortedList.add(root);
		}
		getSortedBetween(k1, k2, root.getRight(), sortedList);
	}
	
}