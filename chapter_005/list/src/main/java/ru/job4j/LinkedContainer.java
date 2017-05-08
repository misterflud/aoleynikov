package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 08.05.2017.
 * @param <E> E
 */
public class LinkedContainer<E> implements SimpleContainer<E> {
    /**
     * Size of LinkedContainer.
     */
    private int size = 0;
    /**
     * First node.
     */
    private Node<E> first;
    /**
     * Last node.
     */
    private Node<E> last;

    /**
     * Adds in container.
     * @param value are added element
     */
    @Override
    public void add(E value) {
        size++;
        if (first == null) {
            createFirst(value);
        } else if (last == null) {
            createLast(value);
        } else {
            Node<E> newNode = new Node<E>(last, value, null);
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * Getter.
     * @param index position
     * @return object E
     */
    @Override
    public E get(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return (E) x.item;

    }

    /**
     * Gets iterator.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private Node<E> x = first;

            private int it = -1;

            @Override
            public boolean hasNext() {
                int it2 = it + 1;
                if (it2 >= size) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                it++;
                if (it != 0) {
                    x = x.next;
                }
                return x.item;
            }
        };
    }

    /**
     * Container with linked on prev and next containers.
     * @param <E> E.
     */
    private static class Node<E> {

        /**
         * Item.
         */
        E item;

        /**
         * Prev.
         */
        Node<E> prev;

        /**
         * Next.
         */
        Node<E> next;

        /**
         * Constructor.
         * @param prev prev
         * @param element element
         * @param next next
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Create first.
     * @param value value
     */
    private void createFirst(E value) {
        first = new Node<E>(null, value, null);
    }

    /**
     * Create last.
     * @param value value
     */
    private void createLast(E value) {
        Node<E> newNode = new Node<E>(first, value, null);
        first.next = newNode;
        last = newNode;
    }
}
