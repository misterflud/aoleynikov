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
public class DeleteServlet extends HttpServlet {
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
        resp.sendRedirect(String.format("%s/views/DeleteUser.jsp", req.getContextPath()));
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
            dataBase.deleteUser(new User(req.getParameter("login")));
            line = "Deleted";
            SingletonPrintOut.getInstance().setString(line);
            resp.sendRedirect(String.format("%s/views/DeleteUser.jsp", req.getContextPath()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
