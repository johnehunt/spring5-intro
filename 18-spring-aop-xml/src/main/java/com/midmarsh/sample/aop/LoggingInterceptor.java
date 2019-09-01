package com.midmarsh.sample.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggingInterceptor implements MethodBeforeAdvice, AfterReturningAdvice {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("Method: "  + method + " called on " + target);
	}

	public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Method: "  + method + " called on " + 
				           target + " returning -> " + result);
	}

}
