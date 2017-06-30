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
public class EchoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()));


        /*
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("Hello world Servlets");
        writer.flush();
        writer.close();
         */
        bufferedWriter.write("Hello gays");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
