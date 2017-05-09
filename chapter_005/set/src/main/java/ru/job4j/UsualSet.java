package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 09.05.2017.
 * @param <T> T
 */
public class UsualSet<T> implements SimpleSet<T> {

    /**
     * Container.
     */
    private Object[] mass = new Object[10];

    /**
     * index.
     */
    private int index = 0;

    /**
     * Adds in container.
     * @param t t
     */
    @Override
    public void add(T t) {
        if (index == mass.length - 1) {
            massBigger();
        }
        if (checkDuplicate(t)) {
            mass[index++] = t;
        }
    }

    /**
     * Gets iterator.
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int it = 0;

            /**
             * Has next?
             *
             * @return true or false
             */
            @Override
            public boolean hasNext() {
                int it2 = it + 1;
                if (it2 > index) {
                    return false;
                }
                return true;
            }

            /**
             * Gives number.
             *
             * @return T.
             */
            @Override
            public T next() {
                return (T) mass[it++];
            }
        };
    }

    /**
     * Checks duplicate in mass[].
     * @param t t
     * @return boolean
     */
    private boolean checkDuplicate(T t) {
        for (int i = 0; i != index; i++) {
            if (mass[i].equals(t)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates mass bigger.
     */
    private void massBigger() {
        Object[] mass2 = new Object[mass.length + 10];
        for (int i = 0; i < mass.length; i++) {
            mass2[i] = mass[i];
        }
        mass = mass2;
    }
}
