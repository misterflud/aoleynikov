package aoleynikov.servlets.servlets;

import aoleynikov.servlets.ConnectionWithDataBase;
import aoleynikov.servlets.User;

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
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
            bufferedWriter.write("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<title>Title</title>" +
                    "</head>" +
                    "<body>" +
                    "<form action='"+ req.getContextPath() +"/delete' method='post'>" +
                    "Login: <input type='text' name='login'/>" +
                    "<input type='submit' name = 'get' value='Delete user'/>" +
                    "</form>" +
                    "<br/>" +
                    line +
                    "</body>" +
                    "</html>");
        }
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
            dataBase.deleteUser(new User(req.getParameter("login")));
            line = "Deleted";
            doGet(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}