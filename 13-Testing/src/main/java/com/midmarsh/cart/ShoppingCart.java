package com.midmarsh.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<String> contents = new ArrayList<String>();
	
	public boolean add(String item) {
		return contents.add(item);
	}
	
	public boolean remove(String item) {
		return contents.remove(item);
	}
	
	public boolean contains(String item) {
		return contents.contains(item);
	}
	
	public void clear() {
		contents.clear();
	}

	public List<String> listContents() {
		// TODO Auto-generated method stub
		return null;
	}

}