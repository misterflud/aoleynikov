package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Anton on 07.05.2017.
 */
public class ContainerTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        Container<Integer> container = new Container<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
        container.add(6);
        container.add(7);
        container.add(8);
        container.add(9);
        container.add(10);
        container.add(11);
        container.add(12);


        Iterator iterator = container.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
