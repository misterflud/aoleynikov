package aoleynikov.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;



/**
 * Created by Anton on 29.06.2017.
 */
public class UsersServlet extends HttpServlet {

    /**
     * Connection with DataBase.
     */
    private ConnectionWithDataBase dataBase = new ConnectionWithDataBase();

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
        resp.setContentType("text/html");

        //User user = dataBase.getUser(new User(req.getParameter("login")));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
            bufferedWriter.write("<!DOCTYPE html>" +
                                      "<html lang=\"en\">" +
                                      "<head>" +
                                        "<meta charset=\"UTF-8\">" +
                                        "<title>Title</title>" +
                                      "</head>" +
                                      "<body>" +
                                      "<form action='"+ req.getContextPath() +"/echo' method='post'>" +
                                        "Login: <input type='text' name='login'/>" +
                                        "<input type='submit' name = 'get' value='Get user'/>" +
                                        "<input type='submit' name = 'del' value='Delete user'/>" +
                                      "</form>" +
                                      "<br/>" +
                                      line +
                                      "</body>" +
                                      "</html>");
            //bufferedWriter.write(String.format("%s %s %s %s", user.name, user.login, user.email, user.timeOfCreate));
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
        resp.setContentType("text/html");

        //dataBase.createUser(new User(name, login, email, new Timestamp(System.currentTimeMillis())));

        User user = dataBase.getUser(new User(req.getParameter("login")));
        line = String.format("<table><tr><td> %s </td><td> %s </td><td> %s </td><td> %s </td></tr></table>",user.name, user.login, user.email, user.timeOfCreate).toString();
        SingletonPrintOut.getInstance().setString(line);
        resp.sendRedirect(String.format("%s/UsersView.jsp", req.getContextPath()));
        //doGet(req, resp);
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
