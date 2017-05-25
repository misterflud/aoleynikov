package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 25.05.2017.
 * @param <T> T
 */
public class FastSet<T> implements SimpleSet<T> {
    /**
     * Container.
     */
    private Object[] mass = new Object[10];
    /**
     * Container of hashsum.
     */
    private int[][] massIter = new int[100][100];
    /**
     * Index.
     */
    private int index = 0;

    /**
     * Adds in container.
     * @param t t
     */
    @Override
    public void add(T t) {
        int hash = t.hashCode();
        double hashDouble = t.hashCode();
        int firstPosition = hash / 100;
        int lastPosition = (int) ((hashDouble / 100 - firstPosition) * 100);
        if (index == mass.length - 1) {
            massBigger();
        }
        if (checkDuplicate(firstPosition, lastPosition)) {
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
     *
     * Checks duplicate in mass[].
     * @param firstPosition [firstPosition][lastPosition]
     * @param lastPosition [firstPosition][lastPosition]
     * @return boolean
     */
    private boolean checkDuplicate(int firstPosition, int lastPosition) {
        if (firstPosition > massIter.length) {
            massIterBigger(firstPosition);
        }
        if (massIter[firstPosition][lastPosition] == 1) {
            return false;
        }
        massIter[firstPosition][lastPosition] = 1;
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

    /**
     * Creates massIter bigger.
     * @param firstPosition [firstPosition][lastPosition]
     */
    private void massIterBigger(int firstPosition) {
        int[][] massIter2 = new int[firstPosition][100];
        for (int i = 0; i < massIter.length; i++) {
            for (int j = 0; j < 100; j++) {
                massIter2[i][j] = massIter[i][j];
            }
        }
        massIter = massIter2;
    }
}
