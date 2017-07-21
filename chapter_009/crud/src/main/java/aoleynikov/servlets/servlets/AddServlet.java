package aoleynikov.servlets.servlets;

import aoleynikov.servlets.ConnectionWithDataBase;
import aoleynikov.servlets.SingletonPrintOut;
import aoleynikov.servlets.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;

/**
 * Created by Anton on 08.07.2017.
 */
public class AddServlet extends HttpServlet {

    /**
     * Request string.
     */
    private String line = "";

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
        resp.sendRedirect(String.format("%s/views/AddUser.jsp", req.getContextPath()));
    }

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
        try(ConnectionWithDataBase dataBase = new ConnectionWithDataBase()) {
            User user = new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Timestamp(System.currentTimeMillis()));
            dataBase.createUser(user);
            line = String.format("<table><tr><td> %s </td><td> %s </td><td> %s </td><td> %s </td></tr></table>", user.name, user.login, user.email, user.timeOfCreate).toString();
            SingletonPrintOut.getInstance().setString(line);
            resp.sendRedirect(String.format("%s/views/AddUser.jsp", req.getContextPath()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
