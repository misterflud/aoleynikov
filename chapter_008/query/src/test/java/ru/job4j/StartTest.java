package ru.job4j;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Anton on 20.06.2017.
 */
public class StartTest {
    @Test
    public void whenThen() {
        final Properties prs = new Properties();
        Start start = new Start();
        ClassLoader load = StartTest.class.getClassLoader();
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
}
