package ru.job4j;

/**
 * Created by Anton on 01.06.2017.
 * @param <E> e
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E>  {
    /**
     * Add child to parent.
     * @param parent parent.
     * @param child child.
     * @return boolean
     */
    boolean add(E parent, E child);
}
