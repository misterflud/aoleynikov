package ru.job4j;

/**
 * Created by Anton on 20.06.2017.
 */
public abstract class BaseFilter implements Filter {

    /**
     * Position in list.
     */
    protected int number;

    /**
     * Constructor.
     * @param number position
     */
    public BaseFilter(int number) {
        this.number = number;
    }

}
