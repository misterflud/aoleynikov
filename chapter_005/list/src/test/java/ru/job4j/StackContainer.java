package ru.job4j;

import org.junit.Test;

/**
 * Created by Anton on 12.05.2017.
 */
public class StackContainerTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        QueueContainer<Integer> queueContainer = new QueueContainer<>();
        queueContainer.enqueue(1);
        queueContainer.enqueue(2);
        queueContainer.enqueue(3);

        System.out.println(queueContainer.dequeue());
        System.out.println(queueContainer.dequeue());
        System.out.println(queueContainer.dequeue());
    }
}
