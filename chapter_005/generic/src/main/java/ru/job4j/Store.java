package ru.job4j;

/**
 *  Created by Anton on 06.05.2017.
 * @param <T> type
 */
public interface Store <T extends Base> {
    /**
     * Adds something.
     * @param t t
     */
    void add(T t);

    /**
     * Deletes  something.
     * @param id id
     */
    void delete(String id);

    /**
     * Update something.
     * @param id id
     * @param t t
     */
    void update(String id, T t);
}
