package ru.job4j;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Anton on 15.03.2017.
 * C:\java\for_tests\Sour.txt
 * C:\java\for_tests2\sfsf.txt
 * Client.txt
 * Sour.txt
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
        String s; //Почему мы не можем использвоать 2ва BufferedReader??? Я же создаю 2объекта этого класса
        try (Scanner reader = new Scanner(System.in)) { //можно конечно вызов доп параметров с сервера (или с клиента) перенести в каждый метод, но на мой взгляд так сложнее
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
        ClassLoader load = Chat.class.getClassLoader(); // интересное решение получения пути вначале к классу, а потом через него к properties
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
        connect(); //заново соединяемся с клиентом
    }

    /**
     *
     * @return String
     * @throws Exception Exception
     */
    @Override
    public String takeMessage() throws Exception {
        String s; //использовать здесь StringBuilder не целесообразно
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
    public void takeFileMessage(String fileName) throws Exception { //прием передача файла взята с сайта: http://yandex.ru/clck/jsredir?from=yandex.ru%3Bsearch%2F%3Bweb%3B%3B&text=&etext=1366.Aq6-nsctFTPj85Q6rWn3BvVYU8ARlizDxqSiniuu0SU.03faf54cf13d69caa77cbcb29fc482019e4f4bc0&uuid=&state=PEtFfuTeVD5kpHnK9lio9dFa2ePbDzX7fH_cbK-eu2V8J4cbFpzDXVHZJKQvpytSeUWqKrUImfJn8iwEFqatOg&data=UlNrNmk5WktYejR0eWJFYk1LdmtxanB2TlY1R2taWUZFUGZYOGxpdnlSaWZjOXBhY09mYTRXU1Q4OFBLdGtzc2VMVFc4Rm9Ka2J0SEF5NnlqMW1qa3NVSUN0QlNERkVvQU4zQl9CaWJhbWxSeEc2Q2JXLUMyY256bDJ1TzRFN1NPdWo2QnBfUFhScw&b64e=2&sign=c27b298371a7c908cecd4f7a45dfdad8&keyno=0&cst=AiuY0DBWFJ4RhQyBNHa0i08fq8GH-io_-Kn852xnEsjDACA-664EmnO5J8y3rTS0qCMJDaVSXWeNnG3HFHlw1nGHPeJlIn-JKgM1l_mjatgTXkzACYLmc8F100GR6uqurfQRq4eAMp2igTG-XwnW7XjP4Sk6rylb8SfxxRaCqcFhRj7gsmiI189INbS3agkHGIOwkYlcuvfQoSJjgw1rW4Z2gabBowccZ2xGP3DiYd9e3IsCwAHH_HNHZZB7IuwjdggGHyPJCHYVRn75mvmng4JEHnizLK2Sg1MpId-LDtM&ref=orjY4mGPRjk5boDnW0uvlrrd71vZw9kpkmljsAJw90dA6nY8rYspzb1UkrbLk3zCkSUKJhUx-yOlyenulVpiVfFHUk3RSvQuXYnCXBbCwyAPNn9eGvxqr_okor2_StyCR0BAlJUxoNXIJKX8NEea3GsAuqS7vrT-Eu7eUUBGPgYAJ07F0lysY1dhRZCSoFOqaprr38UKTEtMKuZyAgcR8AM-9Z1YGXFF&l10n=ru&cts=1490017391167&mc=4.848612747566601
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
