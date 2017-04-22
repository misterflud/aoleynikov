package ru.job4j;

/**
 * Created by Anton on 20.04.2017.
 */
public interface Act {
    /**
     * Executes action.
     */
    void execute();

    /**
     * Take information.
     * @return information.
     */
    String info();
}
