/**
 * 
 */
package ru.aoleynikov.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author Anton Oleynikov
 * created on 01.03.2018
 */
public class CustomerFilter  extends HandlerInterceptorAdapter  {
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();		
		
		if (request.getRequestURI().contains("/start") && session.getAttribute("authUser") == null ) {
			System.out.println(11);
			return true;
		} else if (request.getRequestURI().contains("/start") && session.getAttribute("authUser") != null) {
			System.out.println(22);
			response.sendRedirect("./users");
			return false;
		} else if (session.getAttribute("authUser") == null) {
			System.out.println(33);
			response.sendRedirect("./start");
			return true;
		}
		System.out.println(44);
		return true;
	}
	
}
