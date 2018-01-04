package aoleynikov.servlets.controller;

import static org.junit.Assert.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import aoleynikov.servlets.controller.UsersController;
import aoleynikov.servlets.model.BaseUser;
import aoleynikov.servlets.model.User;

public class UsersControllerTest {

	@Test
	public void addUserTest() throws ServletException, IOException {
		BaseUser baseUser = new User("admin");
		HttpSession session = mock(HttpSession.class);
		when(session.getAttribute("authUser")).thenReturn("admin");
		
		
		UsersController usersController = new UsersController();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		
		when(request.getServletPath()).thenReturn("/getUser");
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("login")).thenReturn("admin");
		
		
		usersController.doGet(request, response);
		
		
		System.out.println(((User) request.getAttribute("getEditUser")).getEmail());//вылетает ошибка, так как JNDI не находит context.xml
		//assertThat(request.getAttribute("getEditUser"));
	}

}
