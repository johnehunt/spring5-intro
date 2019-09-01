package com.midmarsh.spring;

public class PersonFactory {
	
	private PersonFactory() {}
	
	public static Person createNewInstance() {
		return new Person();
	}

}
