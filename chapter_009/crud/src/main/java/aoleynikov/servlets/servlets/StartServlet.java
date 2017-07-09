package aoleynikov.servlets.servlets;

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
public class StartServlet extends HttpServlet {

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

                    "<form action='"+ req.getContextPath() +"/delete' method='get'>" +
                    "<button type='submit'>Delete</button></form>" +
                    "</form>" +

                    "<form action='"+ req.getContextPath() +"/get' method='get'>" +
                    "<button type='submit'>Get</button></form>" +
                    "</form>" +

                    "<form action='"+ req.getContextPath() +"/update' method='get'>" +
                    "<button type='submit'>Update</button></form>" +
                    "</form>" +

                    "<form action='"+ req.getContextPath() +"/add' method='get'>" +
                    "<button type='submit'>Add</button></form>" +
                    "</form>" +

                    "<br/>" +

                    "</body>" +
                    "</html>");
            //bufferedWriter.write(String.format("%s %s %s %s", user.name, user.login, user.email, user.timeOfCreate));
            //req.getContextPath()
        }
    }

}
