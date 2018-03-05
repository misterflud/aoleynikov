/**
 *
 */
package ru.aoleynikov.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 *
 * @author Anton Oleynikov created on 01.03.2018
 */
public class CustomerFilter extends HandlerInterceptorAdapter
{



	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception
	{

		final HttpSession session = request.getSession();

		if (request.getRequestURI().contains("/start") && session.getAttribute("authUser") == null)
		{

			return true;
		}
		else if (request.getRequestURI().contains("/start") && session.getAttribute("authUser") != null)
		{

			response.sendRedirect("./users");
			return false;
		}
		else if (session.getAttribute("authUser") == null)
		{

			response.sendRedirect("./start");
			return true;
		}

		return true;
	}

}
