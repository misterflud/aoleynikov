package ru.job4j;

import java.util.*;

/**
 * Created by Anton on 17.04.2017.
 */
public class SpeedCollection {
    /**
     * Start program.
     * @param args args
     */
    public static void main(String[] args) {
        SpeedCollection speedCollection = new SpeedCollection();
        speedCollection.speedTest(new ArrayList<String>(), new LinkedList<String>(), new TreeSet<String>());
    }

    /**
     * Analysing speed collections.
     * @param collection collections
     */
    public void speedTest(Collection<String>... collection) {
        int n = 1000; //для удаления первых 1000 строк
        String[] strings = new String[100000];
        for (int i = 0; i < strings.length; i++) { //генерация строк
            strings[i] = i + "";
        }

        System.out.println("Замер времени вставки: ");
        for (Collection<String> iter : collection) {
            System.out.println(iter.getClass().getName());
            Date date1 = new Date();
            for (int i = 0; i < strings.length; i++) {
                iter.add(strings[i]);
            }
            Date date2 = new Date();
            System.out.println((int) (date2.getTime() - date1.getTime()) + " Миллисекунд");
        }

        System.out.println("");
        System.out.println("Замер времени удаления: ");
        for (Collection<String> iter : collection) {
            System.out.println(iter.getClass().getName());
            Date date1 = new Date();
            for (int i = 0; i < n; i++) {
                iter.remove(i + "");
            }
            Date date2 = new Date();
            System.out.println((int) (date2.getTime() - date1.getTime()) + " Миллисекунд");
        }
    }
}
