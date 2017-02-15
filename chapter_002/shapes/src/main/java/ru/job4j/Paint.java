package ru.job4j;

import ru.job4j.figures.Shape;

/**
 * Created by Anton on 15.02.2017.
 */
public class Paint {
    /**
     *
     * @param shape shape
     * @return String
     */
    public String draw(Shape shape) {
        return shape.pic();
    }
}
