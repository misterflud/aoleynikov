package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Testing Max.class's.
 *@author Anton Oleynikov
 *version 1
 */
public class MaxTest {
    /**Test add.*/
    @Test
    public void whenSetWthreeNumbersThenTakeMaximumOfThreeNumbres() {
        final int a = 5;
        final int b = 6;
        final int c = 7;
        final int seven = 7;
        Max max = new Max();
        int result = max.max(a, b, c);
        assertThat(result, is(seven));
    }
}