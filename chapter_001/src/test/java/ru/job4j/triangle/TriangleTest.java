package ru.job4j.triangle;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**It's class for testing Triangle.
 *@author Anton Oleynikov
 *@version 1
 */
public class TriangleTest {
    /**
     *Test add.
     */
    @Test
    public void whenPutThreePointsThenTakeArea() {
        final double right = 1.499;
        final double x1 = 1;
        final double x2 = 2;
        final double x3 = 3;
        final double y1 = 2;
        final double y2 = 1;
        final double y3 = 3;
        final double magicNumber = 0.001;
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Point point3 = new Point(x3, y3);
        Triangle triangle = new Triangle(point1, point2, point3);
        double result = triangle.area();
        assertThat(result, closeTo(right, magicNumber));
    }
}