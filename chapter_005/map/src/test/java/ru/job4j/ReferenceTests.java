package ru.job4j;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by Anton on 28.05.2017.
 */
public class ReferenceTests {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        Reference<EasyHash, Integer> map = new Reference<EasyHash, Integer>();

        EasyHash hash1 = new EasyHash(1);
        EasyHash hash2 = new EasyHash(2);
        EasyHash hash3 = new EasyHash(3);
        EasyHash hash4 = new EasyHash(4);
        EasyHash hash5 = new EasyHash(5);
        map.insert(hash1, 1);
        map.insert(hash2, 2);
        map.insert(hash3, 3);
        map.insert(hash4, 4);
        map.insert(hash5, 5);
        map.delete(hash1);

        //System.out.println(map.get(hash1));

        Iterator<Integer> iterator = map.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //--------------------------------- SpeedTest1---------------------------------------------

        Reference<EasyHash, Integer> map2 = new Reference<EasyHash, Integer>();
        HashMap<EasyHash, Integer> hashMap = new HashMap<EasyHash, Integer>();

        Date date1 = new Date();
        for(int i = 0; i < 1000000; i++) {
            try{
                map2.insert(new EasyHash(i), i);
            } catch (Exception e) {
                System.out.println(i);
                throw e;
            }

        }
        Date date2 = new Date();
        System.out.println((int) (date2.getTime() - date1.getTime()) + " Миллисекунд");



        Date date3 = new Date();
        for(int i = 0; i < 1000000; i++) {
            hashMap.put(new EasyHash(i), i);
        }
        Date date4 = new Date();
        System.out.println((int) (date4.getTime() - date3.getTime()) + " Миллисекунд");


        //--------------------------------- SpeedTest2---------------------------------------------
        Iterator<Integer> iterator1 = map2.iterator();
        Date date5 = new Date();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        Date date6 = new Date();
        System.out.println((int) (date6.getTime() - date5.getTime()) + " Миллисекунд");



        Set entrySet = hashMap.entrySet();
        Iterator iterator2 = entrySet.iterator();
        Date date7 = new Date();
        while (iterator2.hasNext()) {
            iterator2.next();
        }
        Date date8 = new Date();
        System.out.println((int) (date8.getTime() - date7.getTime()) + " Миллисекунд");
    }

}
