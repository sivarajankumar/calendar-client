package com.michir.projects.facture.backoffice.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		
		Dynamic servlet = servletContext.addServlet("spring", new DispatcherServlet());
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/spring/*");
	}
}
