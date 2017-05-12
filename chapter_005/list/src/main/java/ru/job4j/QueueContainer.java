package ru.job4j;

import java.util.LinkedList;

/**
 * Created by Anton on 12.05.2017.
 * @param <E> E
 */
public class QueueContainer <E> {
    /**
     * Container.
     */
    LinkedContainer<E> linkedContainer = new LinkedContainer<E>();

    /**
     * Adds.
     * @param e e
     */
    public void enqueue(E e) {
        linkedContainer.add(e);
    }

    /**
     * Gets.
     * @return E
     */
    public E dequeue() {
        return linkedContainer.deleteLast();
    }
}
