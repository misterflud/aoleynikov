package ru.job4j;

/**
 * Created by Anton on 20.06.2017.
 */
public interface Action {

    /**
     * Execute.
     */
    void execute();

    /**
     * Description.
     * @return description.
     */
    String getDescription();
}
