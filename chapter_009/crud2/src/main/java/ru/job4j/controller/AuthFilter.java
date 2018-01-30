package ru.job4j.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//HttpServletRequest request2 = (HttpServletRequest) request;
		((HttpServletResponse) response).sendRedirect(String.format("%s/authUser", ((HttpServletRequest) request).getContextPath()));
		
//		HttpServletRequest request2 = (HttpServletRequest) request;
//		if (request2.getRequestURI().contains("/authUser")) {
//			chain.doFilter(request, response);
//		} else {
//			HttpSession session = request2.getSession();
//			synchronized (session) {
//				if(session.getAttribute("authUser") == null) {
//					//System.out.println("ssssssss");
//					((HttpServletResponse) response).sendRedirect(String.format("%s/authUser", request2.getContextPath()));
//					return;
//				}
//			}
//			chain.doFilter(request, response);
//		}
	}

	@Override
	public void destroy() {
		
		
	}



}
