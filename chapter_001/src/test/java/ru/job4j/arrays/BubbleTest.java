package ru.job4j.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**Test Bubble.
 *@author Anton Oleynikov
 *version 1
 */
public class BubbleTest {
    /**
     *Test1.
     */
    @Test
    public void whenSetArrayThenGetSortArray() {
        final int[] m = {1, 3, 2, 0};
        final int[] should = {0, 1, 2, 3};
        Bubble b = new Bubble();
        int[] result = b.sort(m);
        assertThat(result, is(should));
    }
}