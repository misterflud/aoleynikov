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

    private ConnectionWithDataBase dataBase = new ConnectionWithDataBase(); // НЕ РАБОАЕТ


    /**
     * Gets user.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        User user = dataBase.getUser(new User(req.getParameter("login")));


        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
            bufferedWriter.write(String.format("%s %s %s %s", user.name, user.login, user.email, user.timeOfCreate));
        }
    }

    //http://localhost:8080/items/echo?name=Anton&login=mister&email=@mail

    /**
     * Creates user.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        try {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            dataBase.createUser(new User(name, login, email, new Timestamp(System.currentTimeMillis())));

            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
                bufferedWriter.write("Done!");
                //bufferedWriter.write(name + " " + login + " " + email);
            }
        } catch (Exception e) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
                bufferedWriter.write("NOT!");
            }
        }
        //dataBase.createUser(new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    //http://localhost:8080/items/echo?login=ll
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user = new User(req.getParameter("login"));
        dataBase.deleteUser(user);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
            bufferedWriter.write("Deleted!" + user.login);
        }
    }

}
