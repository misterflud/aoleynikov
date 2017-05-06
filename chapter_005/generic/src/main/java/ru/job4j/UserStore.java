package ru.job4j;

/**
 *  Created by Anton on 06.05.2017.
 * @param <T> type
 */
public class UserStore<T extends Base> extends MainStore<T>{
    /**
     * Constructor.
     * @param size size
     */
    public UserStore(int size) {
        super(size);
    }
}
