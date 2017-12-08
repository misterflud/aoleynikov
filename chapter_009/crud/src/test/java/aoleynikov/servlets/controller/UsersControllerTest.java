package aoleynikov.servlets.controller;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import static org.mockito.Mockito.mock;

import aoleynikov.servlets.controller.UsersController;

public class UsersControllerTest {

	@Test
	public void addUserTest() {
		UsersController usersController = new UsersController();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		usersController.d
	}

}
