package ru.job4j;

/**
 * Created by Anton on 15.05.2017.
 */
public class Node<T> {
    /**
     * Value.
     */
    T value;
    /**
     * Next.
     */
    Node<T> next;

    /**
     * Constructor.
     * @param value value
     */
    public Node(T value) {
        this.value = value;
    }
}
