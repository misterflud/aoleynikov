package ru.job4j;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Anton on 11.06.2017.
 * C:\java\order.xml
 */
public class ManageTest {
    @Test
    public void manageTest() throws Exception {
        Manage manage = new Manage();
        Date date1 = new Date();
        HashMap<String, Book> hashMap = new HashMap<>();
        hashMap.put("book-1", new Book());
        hashMap.put("book-2", new Book());
        hashMap.put("book-3", new Book());
        manage.startGlass("C:\\java\\Справочные материалы\\orders.xml", hashMap);
        Date date2 = new Date();
        System.out.println((int) (date2.getTime() - date1.getTime()) + " Миллисекунд");
    }
}
