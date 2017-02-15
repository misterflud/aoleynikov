package ru.job4j.figures;

/**
 * Created by Anton on 15.02.2017.
 */
public class Square implements Shape {
    /**
     * fig.
     */
    private String fig = "^^^^\r\n^^^^\r\n^^^^\r\n^^^^";
    @Override
    public String pic() {
        return fig;
    }
}
