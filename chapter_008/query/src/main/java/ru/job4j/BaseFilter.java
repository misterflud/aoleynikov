package ru.job4j;

/**
 * Created by Anton on 20.06.2017.
 */
public abstract class BaseFilter implements Filter {

    protected int number;

    public BaseFilter(int number) {
        this.number = number;
    }

}
