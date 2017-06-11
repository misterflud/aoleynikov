package ru.job4j;

import org.junit.Test;

import java.util.Date;

/**
 * Created by Anton on 11.06.2017.
 * C:\java\order.xml
 */
public class ManageTest {
    @Test
    public void manageTest() throws Exception {
        Manage manage = new Manage();
        Date date1 = new Date();
        manage.startGlass("C:\\java\\Справочные материалы\\orders.xml");
        Date date2 = new Date();
        System.out.println((int) (date2.getTime() - date1.getTime()) + " Миллисекунд");
    }
}
