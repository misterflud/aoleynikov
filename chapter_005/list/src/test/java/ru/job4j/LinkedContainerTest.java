package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Anton on 08.05.2017.
 */
public class LinkedContainerTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        LinkedContainer<Integer> linkedContainer = new LinkedContainer<>();
        linkedContainer.add(1);
        linkedContainer.add(2);
        linkedContainer.add(3);
        linkedContainer.add(4);

        System.out.println(linkedContainer.get(0));
        System.out.println("----------------------");

        Iterator iterator = linkedContainer.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
