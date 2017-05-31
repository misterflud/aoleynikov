package ru.job4j;

/**
 * Created by Anton on 30.05.2017.
  *@param <K> key
  * @param <V> value
 */
public interface MyMap <K, V> {
    /**
     * Adds elements.
     * @param key key
     * @param value value
     * @return boolean
     */
    boolean insert(K key, V value);

    /**
     * Gets elements.
     * @param key key
     * @return generic V
     */
    V get(K key);

    /**
     * Deletes elements.
     * @param key key
     * @return boolean
     */
    boolean delete(K key);

}
