package ru.job4j.triangle;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**It's Testclass for Point.
 *@author Anton Oleynikov
 *@version 1
 */
public class PointTest {
    /**
     *Test add.
     */
    @Test
    public void whenPutTwoPointThenTakeDistance() {
        final double right = 1.414;
        final double x1 = 1;
        final double x2 = 2;
        final double y1 = 2;
        final double y2 = 1;
        final double magicNumber = 0.001;
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        double result = point1.distanceTo(point2);
        assertThat(result, closeTo(right, magicNumber));
    }
}