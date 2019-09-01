package com.midmarsh.sample.pojo;

import org.aspectj.lang.JoinPoint;

public class Auditor {
	
	public void printStartMessage(JoinPoint jp) {
		System.out.println("Start up of method call: " + jp);
	}
	
	public void printFinishedMessage(JoinPoint jp) {
		System.out.println("Finished with method call: " + jp);
	}

}
