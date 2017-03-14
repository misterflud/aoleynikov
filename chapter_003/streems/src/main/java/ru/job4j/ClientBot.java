package ru.job4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Anton on 14.03.2017.
 */
public class ClientBot {
    /**
     * port.
     */
    private int port;
    /**
     * ip.
     */
    private String ip;

    /**
     *
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        ClientBot clientBot = new ClientBot();
        clientBot.chatting();
    }

    /**
     *
     * @throws Exception Exception
     */
    public void getDate() throws Exception {
        final Properties prs = new Properties();
        ClassLoader load = Chat.class.getClassLoader(); // иснтересное решение получение пути вначале к классу, а потом через него к properties
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
            prs.load(inputStream);
        }
        port = Integer.parseInt(prs.getProperty("port"));
        ip = prs.getProperty("ip");
    }

    /**
     *
     * @throws Exception Exception
     */
    public void chatting() throws Exception {
        getDate();
        Socket socket = new Socket(InetAddress.getByName(ip), port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //на сервер идет
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //информация с сервера
        Scanner console = new Scanner(System.in);
        String str;
        String serverAnswer;

        out.println("hello");
        System.out.println(String.format("From server: %s", in.readLine())); //считываем приветствие в одну строку
        do {
            str = console.nextLine();
            out.println(str);
            while (!(serverAnswer = in.readLine()).isEmpty()) {
                System.out.println(String.format("From server: %s", serverAnswer));
            }
            serverAnswer = null;
        } while (!"exit".equals(str));

        socket.close();
        out.close();
        in.close();
        console.close();
    }
}
