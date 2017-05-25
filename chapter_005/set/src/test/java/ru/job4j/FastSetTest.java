package ru.job4j;

import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Anton on 25.05.2017.
 */
public class FastSetTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        FastSet<EasyHash> fastSet = new FastSet<>();
        HashSet<EasyHash> hashSet = new HashSet<>();
        UsualSet<EasyHash> usualSet = new UsualSet<>();


        Date date1 = new Date();
        for(int i = 0; i < 10000; i++) {
            fastSet.add(new EasyHash(i, i));
        }
        Date date2 = new Date();
        System.out.println((int) (date2.getTime() - date1.getTime()) + " Миллисекунд");



        Date date3 = new Date();
        for(int i = 0; i < 10000; i++) {
            usualSet.add(new EasyHash(i, i));
        }
        Date date4 = new Date();
        System.out.println((int) (date4.getTime() - date3.getTime()) + " Миллисекунд");



        Date date5 = new Date();
        for(int i = 0; i < 10000; i++) {
            hashSet.add(new EasyHash(i, i));
        }
        Date date6 = new Date();
        System.out.println((int) (date6.getTime() - date5.getTime()) + " Миллисекунд");


        fastSet.add(new EasyHash(1, 1000)); //не должно быть числа 1000
        Iterator<EasyHash> iterator = fastSet.iterator();
        for (int i = 0; i < 102; i++) {
            System.out.println(iterator.next().getNumber()); //не должно быть числа 1000 и его нет)
        }

    }
}
