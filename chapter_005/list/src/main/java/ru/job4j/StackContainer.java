package ru.job4j;

/**
 * Created by Anton on 12.05.2017.
 * @param <E> E
 */
public class StackContainer <E> {

    private LinkedContainer<E> linkedContainer = new LinkedContainer<E>();

    public void push(E e) {
        linkedContainer.add(e);
    }

    public E pop() {
        return linkedContainer.deleteFirst();
    }
}
