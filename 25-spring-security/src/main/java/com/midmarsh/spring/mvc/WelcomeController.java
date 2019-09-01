package com.midmarsh.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.midmarsh.spring.bean.BookService;

@Controller
public class WelcomeController {

	private BookService bookService;

	public WelcomeController(BookService bookService) {
		this.bookService = bookService;
	}

	public ModelAndView buy() throws Exception {
		ModelAndView mav = new ModelAndView("HelloView");
		mav.addObject("message", "John, bought book: " + bookService.buy(1234, 12.99));
		return mav;
	}

	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("HelloView");
		mav.addObject("message", "John (" + bookService.getBook(1234) + ")");
		return mav;
	}

}
