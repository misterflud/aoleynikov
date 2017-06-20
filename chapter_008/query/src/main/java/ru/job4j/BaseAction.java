package ru.job4j;

/**
 * Created by Anton on 20.06.2017.
 */
public abstract class BaseAction implements Action {
    protected int number;

    public BaseAction(int number) {
        this.number = number;
    }
}
