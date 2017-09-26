package ru.aoleynikov;

import java.util.Iterator;

/**
 * Created by Anton on 08.05.2017.
 * @param <E> E
 */
public class LinkedContainerConcurrent<E> implements SimpleContainer<E> {
    /**
     * Size of LinkedContainer.
     */
    private volatile int size = 0;
    /**
     * First node.
     */
    private volatile Node<E> first;
    /**
     * Last node.
     */
    private volatile Node<E> last;

    /**
     * Adds in container.
     * @param value are added element
     */
    @Override
    public synchronized void add(E value) {
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
    public synchronized E get(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return (E) x.item;
    }

    /**
     * Delete last element.
     * @return E
     */
    public synchronized E deleteLast() {
        final E element = last.item;
        final Node<E> prev = last.prev;
        last.item = null;
        last.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    /**
     * Delete first element.
     * @return E
     */
    public synchronized E deleteFirst() {
        final E element = first.item;
        final Node<E> next = first.next;
        first.item = null;
        first.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    /**
     * Gets iterator.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private volatile Node<E> x = first;

            private volatile int it = -1;

            @Override
            public synchronized boolean hasNext() {
                int it2 = it + 1;
                if (it2 >= size) {
                    return false;
                }
                return true;
            }

            @Override
            public synchronized E next() {
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
        volatile E item;

        /**
         * Prev.
         */
        volatile Node<E> prev;

        /**
         * Next.
         */
        volatile Node<E> next;

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
    private synchronized void createFirst(E value) {
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
