package ru.job4j.controller;

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


import java.io.IOException;
import java.io.PrintWriter;




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
    	String uri = req.getRequestURI();
    	
    	System.out.println("get " + action);
    	System.out.println("getUri " + uri);
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
				//edit(req, resp);
				System.out.println("ky ky ky ky");
				break;
			default:
				start(req, resp); 
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
    	System.out.println("post");
    	doGet(req, resp);
    }
    
    
    
    /**
     * Gets user.
     * @param request req
     * @param response resp
     */
    public void getUser(HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	boolean sameUser = false;
    	boolean isAdmin = false;
    	Service service = new Service();
		try {
			BaseUser userFromView = service.get(new User(request.getParameter("login")));
			BaseUser userFromSession = ((BaseUser) session.getAttribute("authUser"));
			if (userFromView.equals(userFromSession)) {
				sameUser = true;
			}
			
			if (userFromSession.getUserRole().getId() == 1) {
				isAdmin = true;
			}
			request.setAttribute("getEditUser", userFromView);
			
			request.setAttribute("sameUser", sameUser);
			request.setAttribute("isAdmin", isAdmin);
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
    	
    	response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
    	System.out.println(request.getRequestURI() + " 111");
    	String s = new Gson().toJson(service.getAll());
    	try {
    	
			//PrintWriter writer = new PrintWriter(response.getOutputStream());
			//writer.append("{\"login\":\"login1\", \"name\":\"name1\", \"email\":\"email1\", \"timeOfCreate\":\"timeOfCreate1\", \"userRole\":\"userRole1\"}");
			//writer.append("[{'login':'login1'}]");
			//writer.append("{'login':'login1'}");
			//String s = "{\"login\":\"login1\"}";
			//String s = "{\"login\":\"login1\", \"name\":\"name1\", \"email\":\"email1\", \"timeOfCreate\":\"timeOfCreate1\", \"userRole\":\"userRole1\"}";
			//String s = "adasdasdasdasdadsa";
			System.out.println(s);
			response.getWriter().write(s);
			//writer.append(s);
			
			
			//writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	Service service = new Service();
//		try {
//			request.setAttribute("listUser", service.getAll());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.html");
//			dispatcher.forward(request, response);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    }
    
    /**
     * Changes jsp to AddUsers.jsp.
     * @param request req
     * @param response resp
     */
    public void add(HttpServletRequest request, HttpServletResponse response) {
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddUsers.html");
//    	HttpSession session = request.getSession();	
//    	boolean adminOrNot = false;
//    	if (((BaseUser) session.getAttribute("authUser")).getUserRole().getId() == 1) {
//    		adminOrNot = true;
//    	}
//    	//System.out.println(adminOrNot  +  " add");
//    	request.setAttribute("adminOrNot", adminOrNot);
//    	
    	
    	
    	try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Changes jsp to UsersUsers.jsp.
     * @param request req
     * @param response resp
     */
    public void get(HttpServletRequest request, HttpServletResponse response) {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.html");
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
    	String password = request.getParameter("password");
    	int id = Integer.parseInt((request.getParameter("role_id")));
    	Role role = (new GeteerRole()).getRole(id);
    	BaseUser user = new AnonUser(name, login, email, password, role);
    	service.addUser(user);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddUsers.jsp");
    	try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Authentications user.
     * @param request request
     * @param response response
     */
    public void authUserPage(HttpServletRequest request, HttpServletResponse response) {
    	
//    	HttpSession session = request.getSession();
//    	session.setAttribute("authUser", new AnonUser("1", "1"));
//    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RegView.html");
//    	try {
//			dispatcher.forward(request, response);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	Service service = new Service();
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	HttpSession session = request.getSession();
    	AnonUser anonUser = new AnonUser(login, password);
    		
	    if (service.authUser(anonUser)) {
	    	BaseUser authUser = service.get(anonUser);
	   
			session.setAttribute("authUser", authUser);
			
			response.setContentType("text/html");
			try {
				((HttpServletResponse) response).sendRedirect(String.format("%s/get", request.getContextPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    } else {
			
	    	try {
				((HttpServletResponse) response).sendRedirect(String.format("%s/start", request.getContextPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
    }
    
    /**
     * Start jsp page -- UsersViews.jsp.
     * @param request
     * @param response
     */
    public void start(HttpServletRequest request, HttpServletResponse response) {	
    	System.out.print("methodStart ");
    	System.out.println(request.getRequestURI() + " 33");
    	
    	response.setContentType("text/html");
    	if (request.getSession().getAttribute("authUser") != null) {
			try {
				((HttpServletResponse) response).sendRedirect(String.format("%s/get", request.getContextPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RegView.html");
        	try {
			dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    /**
     * Deletes user.
     * @param request request
     * @param response response
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) {
    	Service service = new Service();
    	HttpSession session = request.getSession();
    	
    	//System.out.println(request.getParameter("login") + " del");

    	BaseUser user = service.get(new AnonUser(request.getParameter("login")));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
		
		service.deleteUser(user);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Edits user.
     * @param request request
     * @param response response
     */
    public void edit(HttpServletRequest request, HttpServletResponse response) {
    	Service service = new Service();
    	GeteerRole geteerRole = new GeteerRole();
    	String name = request.getParameter("name");
    	String login = request.getParameter("login");
    	String email = request.getParameter("email");
    	Role role = geteerRole.getRole(Integer.parseInt(request.getParameter("userRole")));
    	BaseUser editUser = new AnonUser(name, login, email, role);
    	//System.out.println(request.getParameter("login") + " edit");
    	service.editUser(editUser);
    	//System.out.println(request.getParameter("login"));
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
}
