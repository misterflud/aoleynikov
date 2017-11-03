package aoleynikov.servlets.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aoleynikov.servlets.dao.ConnectionWithDataBaseDao;
import aoleynikov.servlets.model.BaseUser;
import aoleynikov.servlets.model.User;
import aoleynikov.servlets.service.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;



/**
 * Created by Anton on 29.06.2017.
 */
public class UsersController extends HttpServlet {

    /**
     * Connection with DataBase.
     */
    private ConnectionWithDataBaseDao dataBase = new ConnectionWithDataBaseDao();

    private volatile String line = "";

    /**
     * Get.
     * @param req request
     * @param resp response
     * @throws ServletException Exception
     * @throws IOException Exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String action = req.getServletPath();
    	
		switch (action) {
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
			default:
				start(req, resp); //get
				break;
		}
    }

    //http://localhost:8080/items/echo?name=Anton&login=mister&email=@mail

    /**
     * Post.
     * @param req request
     * @param resp response
     * @throws ServletException Exception
     * @throws IOException Exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	/*
        resp.setContentType("text/html");

        //dataBase.createUser(new User(name, login, email, new Timestamp(System.currentTimeMillis())));
        User user = dataBase.getUser(new User(req.getParameter("login")));
        line = String.format("<table><tr><td> %s </td><td> %s </td><td> %s </td><td> %s </td></tr></table>",user.name, user.login, user.email, user.timeOfCreate).toString();
        SingletonPrintOut.getInstance().setString(line);
        resp.sendRedirect(String.format("%s/UsersView.jsp", req.getContextPath()));
        //doGet(req, resp);
 
         */
    	//req.getRequestDispatcher("/WEB_INF/views/UsersView.jsp").forward(req, resp);
    	doGet(req, resp);
    }
    
    
    
    /**
     * Gets user.
     * @param request req
     * @param response resp
     */
    public void getUser(HttpServletRequest request, HttpServletResponse response) {
    	Service service = new Service();
		try {
			request.setAttribute("user", service.get(new User(request.getParameter("login"))));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Gets all users.
     * @param request req
     * @param response resp
     */
    public void getAll(HttpServletRequest request, HttpServletResponse response) {
    	Service service = new Service();
		try {
			request.setAttribute("listUser", service.getAll());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Changes jsp to AddUsers.jsp.
     * @param request req
     * @param response resp
     */
    public void add(HttpServletRequest request, HttpServletResponse response) {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddUsers.jsp");
    	try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Adds user to database.
     * @param request req
     * @param response resp
     */
    public void addUser(HttpServletRequest request, HttpServletResponse response) {
    	Service service = new Service();
    	String name = request.getParameter("name");
    	String login = request.getParameter("login");
    	String email = request.getParameter("email");
    	BaseUser user = new User(name, login, email);
    	service.addUser(user);
  
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddUsers.jsp");
    	try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Start jsp page -- UsersViews.jsp.
     * @param request
     * @param response
     */
    public void start(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * For editing.
     * @param req request
     * @param resp response
     * @throws ServletException Exception
     * @throws IOException Exception
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user1 = new User(req.getParameter("login"));
        User user2 = new User(dataBase.getUser(user1));

    }

    /**
     * For deleting.
     * @param req request
     * @param resp response
     * @throws ServletException Exception
     * @throws IOException Exception
     */
    //http://localhost:8080/items/echo?login=ll
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user = new User(req.getParameter("login"));
        dataBase.deleteUser(user);
        line = "Deleted!";
    }

}
