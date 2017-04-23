package ru.job4j;

/**
 * Created by Anton on 23.04.2017.
 */
public class NotFoundException extends Exception {
    /**
     * Exception.
     * @param s which problem
     */
    public NotFoundException(String s) {
        System.out.println("не найден " + s);
    }
}
