package ru.aoleynikov;

import java.util.Iterator;

/**
 * Created by Anton on 07.05.2017.
 * @param <E> E
 */
public class ContainerConcurrent<E> implements SimpleContainer<E> {

    /**
     * Container.
     */
    private volatile Object[] ob;

    /**
     * Position in container.
     */
    private volatile int index = 0;

    /**
     * Constructor.
     */
    public ContainerConcurrent() {
        ob = new Object[10];
    }
    
    /**
     * Constructor.
     * @param size size
     */
    public ContainerConcurrent(int size) {
        ob = new Object[size];
    }

    /**
     * Adds in container.
     * @param value are added element
     */
    @Override
    public synchronized  void add(E value) {
        if (this.index == ob.length - 1) {
            createBigger();
            ob[this.index++] = value;
        } else {
            ob[this.index++] = value;
        }
    }

    /**
     * Getter.
     * @param index position
     * @return object E
     */
    @Override
    public synchronized  E get(int index) {
        return (E) ob[index];
    }

    /**
     * Gets iterator.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        Iterator<E> iterator = new Iterator<E>() {

        private volatile int it = 0;

            /**
             * Has next?
             * @return true or false
             */
        @Override
        public synchronized  boolean hasNext() {
            int it2 = it + 1;
            if (it2 > index) {
                return false;
            }
            return true;
        }
            /**
             * Gives number.
             * @return  T.
             */
        @Override
        public synchronized E next() {
            return (E) ob[it++];
        }
    };
        return iterator;
    }

    /**
     * If container are full.
     */
    private void createBigger() {
        Object[] ob2 = new Object[ob.length + 10];
        for (int i = 0; i < ob.length; i++) {
            ob2[i] = ob[i];
        }
        ob = ob2;
    }
}
