package ru.job4j;

/**
 * Created by Anton on 30.05.2017.
 */
public interface MyMap <K, V> {

    boolean insert(K key, V value);

    V get(K key);

    boolean delete(K key);

}
