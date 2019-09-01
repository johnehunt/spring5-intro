package com.midmarsh.spring.config;

import javax.servlet.*;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("AppInitializer.onStartup(..)");
		WebApplicationContext context = getContext();
				
		System.out.println("Creating the DispatcherServlet");
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", servlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/app/*");
	}
	
	private AnnotationConfigWebApplicationContext getContext() {
		System.out.println("Creating the ApplicationContext");
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        return context;
    }
}
