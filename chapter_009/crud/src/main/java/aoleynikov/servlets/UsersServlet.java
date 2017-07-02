package aoleynikov.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * Created by Anton on 29.06.2017.
 */
public class UsersServlet extends HttpServlet {

    private ConnectionWithDataBase dataBase = new ConnectionWithDataBase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        User user = dataBase.getUser(new User(req.getParameter("login")));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
            bufferedWriter.write(String.format("%s %s %s %s", user.name, user.login, user.email, user.timeOfCreate));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user = new User(req.getParameter("login"));
        dataBase.deleteUser(user);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
            bufferedWriter.write("Deleted!");
        }
    }
}
