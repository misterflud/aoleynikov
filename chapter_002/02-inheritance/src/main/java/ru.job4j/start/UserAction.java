package ru.job4j.start;

/**
 * Don't use.
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
