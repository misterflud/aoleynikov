package ru.job4j;

/**
 * Created by Anton on 20.06.2017.
 */
public abstract class BaseAction implements Action {

    /**
     * Position in list.
     */
    protected int number;

    /**
     * Constructor.
     * @param number position
     */
    public BaseAction(int number) {
        this.number = number;
    }
}
