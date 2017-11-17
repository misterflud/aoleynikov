package aoleynikov.servlets.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.css.ElementCSSInlineStyle;

import aoleynikov.servlets.dao.ConnectionWithDataBaseDao;
import aoleynikov.servlets.model.AnonUser;
import aoleynikov.servlets.model.BaseUser;
import aoleynikov.servlets.model.User;
import aoleynikov.servlets.service.Service;


import java.io.IOException;




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
    	
    	HttpSession session = req.getSession();
    	if (session.getAttributeNames().hasMoreElements()) {
    		System.out.println(session.getAttributeNames().nextElement());
    	}
    	synchronized (session) {
    		if (session.getAttribute("login") == null && !"/authUser".equals(action.toString())) {
    			System.out.println(action);
    			action = "/start";
    			System.out.println(action);
    		}
		}
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
				authUser(req, resp);
				break;
			case "/get":
				get(req, resp);
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
     * Changes jsp to UsersUsers.jsp.
     * @param request req
     * @param response resp
     */
    public void get(HttpServletRequest request, HttpServletResponse response) {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
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
    
    
    public void authUser(HttpServletRequest request, HttpServletResponse response) {
    	Service service = new Service();
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	
	    if (service.authUser(new AnonUser(login, password))) {
	    	HttpSession session = request.getSession();
	    	synchronized (session) {
				session.setAttribute("login", login);
			}
	 
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
	        try {
	    		dispatcher.forward(request, response);
	    	} catch (ServletException | IOException e) {
	    		e.printStackTrace();
	    	}
	    } else {
	    	request.setAttribute("error", "This user does not exist.");
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RegView.jsp");
	        try {
	    		dispatcher.forward(request, response);
	    	} catch (ServletException | IOException e) {
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
    	HttpSession session = request.getSession();
    	boolean boolSession;
		synchronized (session) {
			boolSession = session.getAttribute("login") == null ? true : false;
		}
		if(boolSession) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RegView.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp");
        	try {
    			dispatcher.forward(request, response);
    		} catch (ServletException | IOException e) {
    			e.printStackTrace();
    		}
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
