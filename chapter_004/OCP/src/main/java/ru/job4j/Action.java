package ru.job4j;

/**
 * Created by Anton on 01.04.2017.
 * Usually, action should have 2 methods.
 * It's give information and execute calculate action.
 */
public interface Action {
    /**
     * Return information about each action.
     * @return String
     */
    String information();

    /**
     * Executing calculate method with some adds (It's about user enter).
     */
    void execute();
}
