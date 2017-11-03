package aoleynikov.servlets.servlets;

import aoleynikov.servlets.SingletonPrintOut;
import aoleynikov.servlets.dao.ConnectionWithDataBaseDao;
import aoleynikov.servlets.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Anton on 08.07.2017.
 */
public class UpdateServlet extends HttpServlet {
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
        resp.sendRedirect(String.format("%s/views/UpdateUser.jsp", req.getContextPath()));
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
        try(ConnectionWithDataBaseDao dataBase = new ConnectionWithDataBaseDao()) {
            User user = dataBase.getUser(new User(req.getParameter("login")));
            user.setName(req.getParameter("name"));
            dataBase.editUser(user);
            line = String.format("<table><tr><td> %s </td><td> %s </td><td> %s </td><td> %s </td></tr></table>", user.getName(), user.getLogin(), user.getEmail(), user.getTimeOfCreate()).toString();
            SingletonPrintOut.getInstance().setString(line);
            resp.sendRedirect(String.format("%s/views/UpdateUser.jsp", req.getContextPath()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
