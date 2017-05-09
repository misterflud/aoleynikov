package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Anton on 09.05.2017.
 */
public class UsualSetTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        UsualSet<Integer> usualSet = new UsualSet<>();
        usualSet.add(1);
        usualSet.add(2);
        usualSet.add(3);
        usualSet.add(4);
        usualSet.add(5);
        usualSet.add(6);
        usualSet.add(7);
        usualSet.add(8);
        usualSet.add(9);
        usualSet.add(10);
        usualSet.add(11);
        Iterator<Integer> iterator = usualSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
