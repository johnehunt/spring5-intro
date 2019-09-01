package com.midmarsh.spring.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// use http://localhost:8080/test/app/welcome/help
@Controller
@RequestMapping("welcome")
public class WelcomeController {

	@RequestMapping("hello")
	public String sayhello(Model model) throws Exception {
		System.out.println("WelcomeController.hello()");
		model.addAttribute("message", "John - " + new Date());
		return "greeting";
	}

	@RequestMapping("help")
	public String getHelp() {
		System.out.println("WelcomeController.help()");
		return "info";
	}
}
