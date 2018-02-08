package ru.job4j.controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AuthFilter implements Filter {

	private Logger logger;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			logger = Logger.getLogger(AuthFilter.class.getName());
//			logger.log(Level.INFO, path + " 1");
			FileHandler fh = new FileHandler("D:/javaLearn/javacodegeeks.log");
			logger.addHandler(fh);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		

		
//		System.out.println((String.format("%s/", ((HttpServletRequest) request).getContextPath())));
//		((HttpServletResponse) response).sendRedirect(String.format("%s/", ((HttpServletRequest) request).getContextPath()));
//		chain.doFilter(request, response);
		

		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpSession session = request2.getSession();
		String path = request2.getRequestURI();
		if (path.contains("resources") || path.contains(".html")  || path.contains(".jpg")) {

			System.out.println(path + " 1");
			chain.doFilter(request, response);
		} else if (path.contains("/authUser") || path.contains("/start")) {
			
			System.out.println(path + " 2");
			chain.doFilter(request, response);
		} else if (session.getAttribute("authUser") == null) {
			
			System.out.println(path + " 3");
			((HttpServletResponse) response).sendRedirect(String.format("%s/start", request2.getContextPath()));

//			((HttpServletResponse) response).sendRedirect(request2.getContextPath() + "/start");
//			request.getRequestDispatcher(request2.getRequestURI().substring(request2.getContextPath().length()) + "/start").forward(request, response);
			
			System.out.println(path + " 3333");
			//chain.doFilter(request, response);
		} else {
			System.out.println(path + " 4");
			//((HttpServletResponse) response).sendRedirect(String.format("%s/", request2.getContextPath()));
		}
		
		
		

	}

	@Override
	public void destroy() {
		
		
	}



}
