
package ru.job4j;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 15.02.2017.
 */
public class PaintTest {

    /**
     * Test1.
     */
    @Test
    public void whenPutFigureThenPrintIt() {
        Paint paint = new Paint();
        final String expected = "  ^  \r\n ^^^ \r\n^^^^^";
        String result = paint.draw(new Triangle());
        System.out.println(result);
        assertThat(expected, is(result));
    }
}
