package ru.mzto;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Anton on 15.03.2017.
 */
public class ClientNetFileManager implements ClientManager {
    /**
     * Just one.
     */
    private final String one = "1";
    /**
     * Just two.
     */
    private final String two = "2";
    /**
     * Just three.
     */
    private final String three = "3";
    /**
     * Just four.
     */
    private final String four = "4";
    /**
     * Just five.
     */
    private final String five = "5";
    /**
     * port.
     */
    private int port;
    /**
     * socket.
     */
    private Socket socket;
    /**
     * ip.
     */
    private String ip;
    /**
     * reader.
     */
    private BufferedReader reader;
    /**
     * printWriter.
     */
    private PrintWriter printWriter;
    /**
     * directory.
     */
    private String directory;
    /**
     * Start directory.
     */
    private OutputStream out;
    /**
     * in.
     */
    private InputStream in;

    /**
     *
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        ClientNetFileManager clientNetFileManager = new ClientNetFileManager();
        clientNetFileManager.manage();
    }

    /**
     *
     * start program.
     * @throws Exception Exception
     */
    @Override
    public void manage() throws Exception {
        getProperties();
        connect();
        System.out.println(takeMessage());
        sendMessage("From client: Connect is done");
        System.out.println(takeMessage());
        String s;
        try (Scanner reader = new Scanner(System.in)) {
            do {
                s = reader.nextLine();
                if (one.equals(s)) { //получить список корневого каталога
                    sendMessage(s);
                    System.out.println(takeMessage());
                } else if (two.equals(s)) { //2 перейти в подкаталог
                    sendMessage(s);
                    System.out.println(takeMessage());
                    sendMessage(reader.nextLine());
                    System.out.println(takeMessage());
                } else if (three.equals(s)) { //3 спуститься в родительский каталог
                    sendMessage(s);
                    System.out.println(takeMessage());
                    System.out.println(takeMessage());
                } else if (four.equals(s)) { //4 скачать файл с сервера
                    sendMessage(s);
                    System.out.println(takeMessage());
                    String fileName = reader.nextLine(); //отправляем название нужного файла
                    sendMessage(fileName);
                    takeFileMessage(fileName);
                } else if (five.equals(s)) { //5 загрузить файл на сервер
                    sendMessage(s);
                    System.out.println(takeMessage());
                    sendMessage(reader.nextLine()); //название файла отправляем вместе с расширением
                    System.out.println("Напишите полный путь к файлу, который хотите скачать");
                    sendFile(reader.nextLine()); //вызываем клиентский метод и пишем полный путь к файлу
                    System.out.println(takeMessage());
                }
            } while (!"exit".equals(s));
            sendMessage(s); //отправляем exit слиенту
        }
        closeStreams();
    }

    /**
     *
     * @throws Exception Exception
     */
    @Override
    public void getProperties() throws Exception {
        final Properties prs = new Properties();
        ClassLoader load = ClientNetFileManager.class.getClassLoader();
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
            prs.load(inputStream);
        }
        port = Integer.parseInt(prs.getProperty("port"));
        ip = prs.getProperty("ip");
        directory = prs.getProperty("startDirForClient");
    }

    /**
     *
     * @throws Exception Exception
     */
    @Override
    public void connect() throws Exception {
        socket = new Socket(InetAddress.getByName(ip), port);
        in = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in));
        out = socket.getOutputStream();
        printWriter = new PrintWriter(out, true);
    }

    /**
     *
     * @param message message
     * @throws Exception Exception
     */
    @Override
    public void sendMessage(String message) throws Exception {
        printWriter.println(message);
    }

    /**
     *
     * @param filePath filePath
     * @throws Exception Exception
     */
    @Override
    public void sendFile(String filePath) throws Exception {
        File file = new File(filePath);
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] fileByteArray = new byte[(int) file.length()];
            bufferedInputStream.read(fileByteArray, 0, fileByteArray.length);
            out.write(fileByteArray, 0, fileByteArray.length);
            out.flush();
        }
        closeStreams();
        connect(); //опять соединяемся с клиентом
    }

    /**
     *
     * @return String
     * @throws Exception Exception
     */
    @Override
    public String takeMessage() throws Exception {
        String s;
        String s2 = ""; //использовать здесь StringBuilder не целесообразно
        while (!(s = reader.readLine()).isEmpty()) {
            s2 += s + "\n";
        }
        return s2;

    }

    /**
     *
     * @param fileName fileName
     * @throws Exception Exception
     */
    @Override
    public void takeFileMessage(String fileName) throws Exception {
        File file = new File(directory  + "\\" +  fileName);
        final int fileSize = 6022386;
        byte[] fileByteArray  = new byte[fileSize];
        int current;
        int bytesRead;
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            bytesRead = in.read(fileByteArray, 0, fileByteArray.length);
            current = bytesRead;
            do {
                bytesRead = in.read(fileByteArray, current, (fileByteArray.length - current));
                if (bytesRead >= 0) {
                    current += bytesRead;
                }
            } while (bytesRead > -1);

            bufferedOutputStream.write(fileByteArray, 0, current);
            bufferedOutputStream.flush();
        }
        closeStreams();
        connect(); //каждый раз после приема файла соединяемся заново
    }

    /**
     *
     * @throws Exception Exception
     */
    @Override
    public void closeStreams() throws Exception {
        socket.close();
        reader.close();
        printWriter.close();
        out.close();
        in.close();
    }
}
