package ru.job4j;

/**
 * Created by Anton on 09.05.2017.
 * @param <T> T
 */


public interface SimpleSet<T> extends Iterable<T> {
    /**
     * Adds in container.
     * @param t t
     */
    void add(T t);
}
