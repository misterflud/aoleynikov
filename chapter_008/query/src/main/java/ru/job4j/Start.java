package ru.job4j;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Anton on 20.06.2017.
 */
public class Start {
    /**
     * Main.
     * @param args args.
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception{
        final Properties prs = new Properties();
        Start start = new Start();
        ClassLoader load = Start.class.getClassLoader();
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
            prs.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }



        try (Connect connect = new ConnectionWithUser()) {
            try (FilterManager filterManager = new FilterManager(connect, prs.getProperty("username"), prs.getProperty("password"), prs.getProperty("url"))) {
                start.manage(connect, filterManager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Connections with user.
     * @param connect connect
     * @param filterManager filterManager
     */
    public void manage(Connect connect, FilterManager filterManager) {
        String s;
        Menu menu = new Menu(connect, filterManager);
        do {
            connect.sendAnswer("Select action or write <exit>");
            menu.getActions();
            s = connect.takeAnswer();
            if ("exit".equals(s)) {
                break;
            }
            menu.execute(Integer.parseInt(s));
        } while (true);
    }
}
