package ru.job4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * Created by Anton on 14.03.2017.
 */
public class ServerBot {
    /**
     * port.
     */
    private int port;

    /**
     *
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        ServerBot serverBot = new ServerBot();
        serverBot.connect();
    }

    /**
     *
     * @throws Exception Exception
     */

    public void getDate() throws Exception {
        final Properties prs = new Properties();
        ClassLoader load = Chat.class.getClassLoader(); // интересное решение получение пути вначале к классу, а потом через него к properties
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
            prs.load(inputStream);
        }
        port = Integer.parseInt(prs.getProperty("port"));
        System.out.println(port);
    }

    /**
     *
     * @throws Exception Exception
     */
    public void connect() throws Exception {
        getDate();
        try (Socket socket =  new ServerSocket(port).accept(); PrintWriter out = new PrintWriter(socket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            Chat chat = new Chat(); //ДЛЯ ответов используем программу консольный чат.
            String ask;
            String answer;
            do {
                ask = in.readLine();
                System.out.println(String.format("from client: %s", ask));
                if ("hello".equals(ask)) {
                    answer = "Hello, dear friend, I'm a oracle.";
                    out.println(answer);
                    System.out.println(String.format("Sent: %s", answer));
                    out.println(); //пустые строки
                } else {
                    answer = chat.answer();
                    out.println(answer);
                    System.out.println(String.format("Sent: %s", answer));
                    out.println();
                }
            } while (!"exit".equals(ask));
        }
    }
}
