package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 03.05.2017.
 */
public class SimpleIterator<T> implements Iterator<T> {
    /**
     * Main mass.
     */
    private T[] mass;
    /**
     * Iterator.
     */
    int it = 0;
    /**
     * Length of mass.
     */
    int len;

    /**
     * Constructor.
     * @param mass mass
     */
    public SimpleIterator(T[] mass) {
        this.mass = mass;
        this.len = mass.length;
    }
    /**
     * Has next?
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        return it + 1 <= len;
    }
    /**
     * Gives number.
     * @return  T.
     */
    @Override
    public T next() {
        return mass[it++];
    }
}
