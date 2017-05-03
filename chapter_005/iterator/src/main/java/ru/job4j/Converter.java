package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 02.05.2017.
 */
public interface Converter{
    /**
     * Converts to simple iterator.
     * @param it it
     * @return iterator for usually getting numbers
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
