package ru.job4j;

/**
 * Created by Anton on 07.05.2017.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    void add(E value);

    E get(int index);
}
