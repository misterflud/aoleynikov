package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 03.05.2017.
 */
public class IteratorOfIterators implements Converter, Iterator {
    /**
     * Iterators.
     */
    private Iterator<Iterator<Integer>> it;
    /**
     * Numbers.
     */
    private Iterator<Integer> itInteger;
    /**
     * Integer.
     */
    private int result;
    /**
     * Has next?
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        if (!it.hasNext() && !itInteger.hasNext()) {
            return false;
        }
        return true;
    }

    /**
     * Gives number.
     * @return  int
     */
    @Override
    public Object next() {
        result = itInteger.next();
        if (!itInteger.hasNext()) {
            if (it.hasNext()) {
                itInteger = it.next();
                result = itInteger.next();
            }
        }
        return result;
    }

    /**
     * Converts to simple iterator.
     * @param it it
     * @return iterator for usually getting numbers
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.it = it;
        itInteger = this.it.next();
        return this;
    }
}
