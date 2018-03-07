package ru.job4j.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import ru.job4j.dao.ConnectionWithDataBaseDao;
import ru.job4j.model.AnonUser;
import ru.job4j.model.BaseUser;
import ru.job4j.model.GeteerRole;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.service.Service;




/**
 * Created by Anton on 29.06.2017.
 */
public class UsersController extends HttpServlet
{

	/**
	 * Connection with DataBase.
	 */
	private final ConnectionWithDataBaseDao dataBase = new ConnectionWithDataBaseDao();

	private volatile String line = "";

	/**
	 * Get.
	 *
	 * @param req
	 *           request
	 * @param resp
	 *           response
	 * @throws ServletException
	 *            Exception
	 * @throws IOException
	 *            Exception
	 */
	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
	{
		final String action = req.getServletPath();
		final String uri = req.getRequestURI();

		System.out.println("get " + action);
		System.out.println("getUri " + uri);
		switch (action)
		{
			case "/add":
				add(req, resp);
				break;
			case "/getAll":
				getAll(req, resp);
				break;
			case "/getUser":
				getUser(req, resp);
				break;
			case "/addUser":
				addUser(req, resp);
				break;
			case "/authUser":
				authUserPage(req, resp);
				break;
			case "/get":
				get(req, resp);
				break;
			case "/deleteUser":
				delete(req, resp);
				break;
			case "/saveEdit":
				edit(req, resp);
				break;
			default:
				start(req, resp);
				break;
		}
	}

	//http://localhost:8080/items/echo?name=Anton&login=mister&email=@mail

	/**
	 * Post.
	 *
	 * @param req
	 *           request
	 * @param resp
	 *           response
	 * @throws ServletException
	 *            Exception
	 * @throws IOException
	 *            Exception
	 */
	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("post");
		doGet(req, resp);
	}



	/**
	 * Gets user.
	 *
	 * @param request
	 *           req
	 * @param response
	 *           resp
	 */
	public void getUser(final HttpServletRequest request, final HttpServletResponse response)
	{
		final HttpSession session = request.getSession();
		boolean sameUser = false;
		boolean isAdmin = false;
		final Service service = new Service();
		final BaseUser userFromView = service.get(new User(request.getParameter("login")));
		final BaseUser userFromSession = ((BaseUser) session.getAttribute("authUser"));

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if (userFromView.equals(userFromSession))
		{
			sameUser = true;
		}
		if (userFromSession.getUserRole().getId() == 1)
		{
			isAdmin = true;
		}
		final String s = new Gson().toJson(service.get(userFromView));
		//		request.setAttribute("sameUser", sameUser);
		//		request.setAttribute("isAdmin", isAdmin);
		try
		{
			System.out.println(s);
			response.getWriter().write(s);
		}
		catch (final IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * Gets all users.
	 *
	 * @param request
	 *           req
	 * @param response
	 *           resp
	 */
	public void getAll(final HttpServletRequest request, final HttpServletResponse response)
	{
		final Service service = new Service();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println(request.getRequestURI() + " 111");
		final String s = new Gson().toJson(service.getAll());
		try
		{
			System.out.println(s);
			response.getWriter().write(s);
		}
		catch (final IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Changes jsp to AddUsers.jsp.
	 *
	 * @param request
	 *           req
	 * @param response
	 *           resp
	 */
	public void add(final HttpServletRequest request, final HttpServletResponse response)
	{

		final RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddUsers.html");
		//    	HttpSession session = request.getSession();
		//    	boolean adminOrNot = false;
		//    	if (((BaseUser) session.getAttribute("authUser")).getUserRole().getId() == 1) {
		//    		adminOrNot = true;
		//    	}
		//    	//System.out.println(adminOrNot  +  " add");
		//    	request.setAttribute("adminOrNot", adminOrNot);
		//


		try
		{
			dispatcher.forward(request, response);
		}
		catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Changes jsp to UsersUsers.jsp.
	 *
	 * @param request
	 *           req
	 * @param response
	 *           resp
	 */
	public void get(final HttpServletRequest request, final HttpServletResponse response)
	{
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.html");
		try
		{
			dispatcher.forward(request, response);
		}
		catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}


	/**
	 * Adds user to database.
	 *
	 * @param request
	 *           req
	 * @param response
	 *           resp
	 */
	public void addUser(final HttpServletRequest request, final HttpServletResponse response)
	{

		final Service service = new Service();
		final String name = request.getParameter("name");
		final String login = request.getParameter("login");
		final String email = request.getParameter("email");
		final String password = request.getParameter("password");
		final int id = Integer.parseInt((request.getParameter("role_id")));
		System.out.println("_________________" + name + " " + login + " " + email + " " + password + " " + id);
		final Role role = (new GeteerRole()).getRole(id);
		final BaseUser user = new AnonUser(name, login, email, password, role);
		service.addUser(user);
	}

	/**
	 * Authentications user.
	 *
	 * @param request
	 *           request
	 * @param response
	 *           response
	 */
	public void authUserPage(final HttpServletRequest request, final HttpServletResponse response)
	{

		//    	HttpSession session = request.getSession();
		//    	session.setAttribute("authUser", new AnonUser("1", "1"));
		//    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RegView.html");
		//    	try {
		//			dispatcher.forward(request, response);
		//		} catch (ServletException | IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		final Service service = new Service();
		final String login = request.getParameter("login");
		final String password = request.getParameter("password");
		final HttpSession session = request.getSession();
		final AnonUser anonUser = new AnonUser(login, password);

		if (service.authUser(anonUser))
		{
			final BaseUser authUser = service.get(anonUser);

			session.setAttribute("authUser", authUser);

			response.setContentType("text/html");
			try
			{
				response.sendRedirect(String.format("%s/get", request.getContextPath()));
			}
			catch (final IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else
		{

			try
			{
				response.sendRedirect(String.format("%s/start", request.getContextPath()));
			}
			catch (final IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Start jsp page -- UsersViews.jsp.
	 *
	 * @param request
	 * @param response
	 */
	public void start(final HttpServletRequest request, final HttpServletResponse response)
	{
		System.out.print("methodStart ");
		System.out.println(request.getRequestURI() + " 33");

		response.setContentType("text/html");
		if (request.getSession().getAttribute("authUser") != null)
		{
			try
			{
				response.sendRedirect(String.format("%s/get", request.getContextPath()));
			}
			catch (final IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			final RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RegView.html");
			try
			{
				dispatcher.forward(request, response);
			}
			catch (final ServletException e)
			{
				e.printStackTrace();
			}
			catch (final IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Deletes user.
	 *
	 * @param request
	 *           request
	 * @param response
	 *           response
	 */
	public void delete(final HttpServletRequest request, final HttpServletResponse response)
	{
		final Service service = new Service();
		final HttpSession session = request.getSession();
		final BaseUser user = service.get(new AnonUser(request.getParameter("login")));
		service.deleteUser(user);
	}

	/**
	 * Edits user.
	 *
	 * @param request
	 *           request
	 * @param response
	 *           response
	 */
	public void edit(final HttpServletRequest request, final HttpServletResponse response)
	{
		final Service service = new Service();
		final GeteerRole geteerRole = new GeteerRole();
		final String name = request.getParameter("name");
		final String login = request.getParameter("login");
		final String email = request.getParameter("email");
		final Role role = geteerRole.getRole(Integer.parseInt(request.getParameter("userRole")));
		final BaseUser editUser = new AnonUser(name, login, email, role);
		//System.out.println(request.getParameter("login") + " edit");
		service.editUser(editUser);
		//System.out.println(request.getParameter("login"));
	}

	/**
	 * For editing.
	 *
	 * @param req
	 *           request
	 * @param resp
	 *           response
	 * @throws ServletException
	 *            Exception
	 * @throws IOException
	 *            Exception
	 */
	@Override
	protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		final User user1 = new User(req.getParameter("login"));
		final User user2 = new User(dataBase.getUser(user1));
	}
}
