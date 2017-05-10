package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Anton on 10.05.2017.
 */
public class LinkedSetContainerTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        LinkedSetContainer<Integer> linkedSetContainer = new LinkedSetContainer();
        linkedSetContainer.add(1);
        linkedSetContainer.add(2);
        linkedSetContainer.add(2);
        linkedSetContainer.add(3);
        Iterator iterator = linkedSetContainer.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
