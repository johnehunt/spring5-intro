package com.midmarsh.spring.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath*:*Context.xml")
@ActiveProfiles("dev")
public class ProfileTest {
	
	@Autowired
	String name;
	
	@Autowired
	String info;
	
	@Test
	public void DoTest() {
		Assertions.assertNotNull(name);
		Assertions.assertNotNull(info);
		System.out.println(name);
		System.out.println(info);
	}

}
