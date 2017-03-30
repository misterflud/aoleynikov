package ru.job4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * Created by Anton on 15.03.2017.
 *
 */
public class ServerNetFileManager implements ServerManager {
    /**
     * port.
     */
    private int port;
    /**
     * serverSocket.
     */
    private ServerSocket serverSocket;
    /**
     *socket.
     */
    private Socket socket;
    /**
     * printWriter.
     */
    private PrintWriter printWriter; //поток на клиент
    /**
     * out.
     */
    private OutputStream out;
    /**
     * in.
     */
    private BufferedReader reader; //поток с клиента

    private InputStream in;
    /**
     * directory.
     */
    private String directory;

    /**
     *
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        ServerNetFileManager serverNetFileManager = new ServerNetFileManager();
        serverNetFileManager.menuStart("C:\\java\\for_tests"); //куда залить файл
    }

    /**
     *
     * @param defaultDir defaultDir
     * @throws Exception Exception
     */
    @Override
    public void menuStart(String defaultDir) throws Exception {
        directory = defaultDir;
        getProperties();
        connect();
        sendMessage("From server: Connect is done"); //как обнулить выходящий поток???????????
        System.out.println(takeMessage());
        sendMessage(String.format("%s\n %s\n %s\n %s\n %s\n %s", "1 получить список корневого каталога", "2 перейти в подкаталог", "3 спуститься в родительский каталог", "4 скачать файл с сервера", "5 загрузить файл на сервер", "напишите <exit> для выхода из программы"));
        String s;
         do { //можно было упростить меню убрав текстовые команды в методы
            s = takeMessage();
            if ("1".equals(s)) { //получить список корневого каталога
                sendMessage(listDir(directory)); //постоянно отправляем данные об директории
            } else if ("2".equals(s)) { //2 перейти в подкаталог
                sendMessage("напишите путь подкаталога");
                changeDir(takeMessage());
                sendMessage(listDir(directory));
            } else if ("3".equals(s)) { //3 спуститься в родительский каталог
                sendMessage("спускаюсь в родительский подкаталог");
                parentDir();
                sendMessage(listDir(directory));
            } else if ("4".equals(s)) { //4 скачать файл с сервера
                sendMessage("напишите название файла из этой дирктории"); //выбираем на сревере файл по имени и отрпавляем файл клиенту
                sendFile(takeMessage());
            } else if ("5".equals(s)) { //5 загрузить файл на сервер (новое)
                sendMessage("скачиваю файл в данную директорию. Напишите название файла с расширением");
                takeFileMessage(takeMessage()); //начинаем принимать файл
                sendMessage(listDir(directory));
            }
        } while (!"exit".equals(s));
        serverSocket.close();
        reader.close();
        out.close();
        printWriter.close();
    }

    /**
     *
     * @param dir directory
     * @return files
     * @throws Exception Exception
     */
    @Override
    public String listDir(String dir) throws Exception { //получаем список всех файлов в каталоге
        File[] files = new File(dir).listFiles();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < files.length - 1; i++) {
            stringBuilder.append(files[i].getAbsolutePath());
            stringBuilder.append("\n");
        }
        stringBuilder.append(files[files.length - 1].getAbsolutePath());
        return stringBuilder.toString();

    }

    /**
     *
     * @param dir appointment directory
     * @throws Exception
     */
    @Override
    public void changeDir(String dir) throws Exception { //меняем директорию
        File file = new File(dir); //можно убрать
        directory = file.getAbsolutePath();
    }

    /**
     * go to parent directory.
     * @throws Exception Exception
     */
    @Override
    public void parentDir() throws Exception { //переход в родительскую директорию
        File file = new File(directory);
        directory = file.getParent();
    }

    /**
     * using Properties.
     * @throws Exception Exception
     */
    @Override
    public void getProperties() throws Exception { //получаем данные из properties
        final Properties prs = new Properties();
        ClassLoader load = Chat.class.getClassLoader();
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
            prs.load(inputStream);
        }
        port = Integer.parseInt(prs.getProperty("port"));
    }

    /**
     * first connect.
     * @throws Exception Exception
     */
    @Override
    public void connect() throws Exception { //соединяемся
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        in = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in));
        out = socket.getOutputStream(); // на более низкий уровень перейдем, ибо это понадобится для передачи файлов
        printWriter = new PrintWriter(out, true); //почему при закрытии out закрывается serverSocket???
        //dataOutputStream = new DataOutputStream(out); //тоже самое закрываем поток -- закрывается и сокет((( ПРИ ЧЕМ если передавать данные через dataOutputStream а принимать
                                                        //через BufferedReader то ничего не получается -- почему -- пока не ясно
    }

    /**
     * second connect(after sending file).
     * @throws Exception Exception
     */
    public void connect2() throws Exception { //перезапускаем сокет (серверный сокет остается прежним)
        socket = serverSocket.accept();
        in = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in));
        out = socket.getOutputStream();
        printWriter = new PrintWriter(out, true);
    }

    /**
     * Send text.
     * @param message text message
     * @throws Exception Exception
     */
    @Override
    public void sendMessage(String message) throws Exception { //отправляем сообщение клиенту
        printWriter.println(message);
        printWriter.println();
    }

    /**
     * Send file and use restart connect(connect2).
     * @param fileName fileName
     * @throws Exception Exception
     */
    @Override
    public void sendFile(String fileName) throws Exception { //отправляем файл
        File file = new File(directory + "\\" + fileName);
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] fileByteArray = new byte[(int) file.length()];
            bufferedInputStream.read(fileByteArray, 0, fileByteArray.length);
            out.write(fileByteArray, 0, fileByteArray.length);
            out.flush();
        }
        closeStreams();
        connect2(); //заново соединяемся с клиентом
    }

    /**
     * Take message from client.
     * @return String
     * @throws Exception Exception
     */
    @Override
    public String takeMessage() throws Exception { //получаем сообщение
        return reader.readLine();
    }

    /**
     * Take file from client.
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
        closeStreams(); //закроем потоки, хотя некоторые или все должны были уже закрыться
        connect2();
    }

    /**
     * Close streams when file was sent, because when we want save file we must close streams.
     * @throws Exception Exception
     */
    @Override
    public void closeStreams() throws Exception { //закрываем часть потоков (для перезапуска соединения)
        socket.close();
        in.close();
        reader.close();
        out.close();
        printWriter.close();
    }
}
