package ru.job4j.loops;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**Test paint.
 *@author Anton Oleynikov
 *@version 1
 */
public class PaintTest {
    /**
     *Test.
     */
    @Test
    public void whenSetNumberThenPaintPiramid() {
        final int number = 5;
        final String should = "    ^    \r\n   ^ ^   \r\n  ^   ^  \r\n ^     ^ \r\n^       ^\r\n";
        Paint paint = new Paint();
        String result = paint.piramid(number);
        System.out.print(result);
        System.out.print(should);
        assertThat(result, is(should));
    }
}