package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 07.05.2017.
 */
public class Container<E> implements SimpleContainer<E> {

    /**
     * Container.
     */
    private Object[] ob;

    /**
     * Position in container.
     */
    private int index = 0;

    /**
     * Constructor.
     */
    public Container() {
        ob = new Object[10];

    }
    /**
     * Constructor.
     */
    public Container(int size) {
        ob = new Object[size];
    }

    /**
     * Adds in container.
     * @param value are added element
     */
    @Override
    public void add(E value) {
        if(this.index == ob.length - 1) {
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
    public E get(int index) {
        return (E) ob[index]; //опять
    }

    /**
     * Gets iterator.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        Iterator<E> iterator = new Iterator<E>() {

        private int it = 0;

            /**
             * Has next?
             * @return true or false
             */
        @Override
        public boolean hasNext() {
            int it2 = it + 1;
            if(it2 > index) {
                return false;
            }
            return true;
        }
            /**
             * Gives number.
             * @return  T.
             */
        @Override
        public E next() {
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
