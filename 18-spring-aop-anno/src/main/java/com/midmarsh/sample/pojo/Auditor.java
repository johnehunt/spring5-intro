package com.midmarsh.sample.pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Auditor {

	@Around("execution(* com.midmarsh.sample.employee.*.*(..))")
	public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Start call to: " + pjp.getSignature());
		Object obj = pjp.proceed();
		System.out.println("Ending call to: " + pjp.getSignature());
		return obj;
	}

}
