package ru.job4j;


/**
 * Created by Anton on 07.05.2017.
 * @param <E> E
 */
public interface SimpleContainer<E> extends Iterable<E> {

    /**
     * Adds in container.
     * @param value are added element
     */
    void add(E value);

    /**
     * Getter.
     * @param index position
     * @return object E
     */
    E get(int index);
}
