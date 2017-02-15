package ru.job4j;

/**
 * Created by Anton on 15.02.2017.
 */
public class Triangle implements Shape {
    /**
     * figure.
     */
    private String fig = "  ^  \r\n ^^^ \r\n^^^^^";
    @Override
    public String pic() {
        return fig;
    }
}
