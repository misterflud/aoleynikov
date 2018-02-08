package ru.job4j.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Anton Oleynikov
 * created on 02.02.2018
 */
public class UserJsonController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("JSONget");
//		resp.setContentType("text/json");
//		PrintWriter writer = new PrintWriter(resp.getOutputStream());
//		writer.append("dfgdfgd");
//		writer.flush();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/RegView.html");
		//dispatcher.forward(req, resp);
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/RegView.html");
//		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
	
	
}
