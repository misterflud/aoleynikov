package ru.job4j.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**Test TurnArray.
 *@author Anton Oleynikov
 *version 1
 */
public class TurnArrayTest {
    /**
     *Test1.
     */
    @Test
    public void whenSetArrayOddThenGetReverse() {
        final int[] m = {1, 2, 3};
        final int[] should = {3, 2, 1};
        TurnArray ta = new TurnArray();
        int[] result = ta.back(m);
        assertThat(result, is(should));
    }
    /**
     *Test2.
     */
    @Test
    public void whenSetArrayEvenThenGetReverse() {
        final int[] m = {1, 2, 3, 4};
        final int[] should = {4, 3, 2, 1};
        TurnArray ta = new TurnArray();
        int[] result = ta.back(m);
        assertThat(result, is(should));
    }
    /**
     *Test3.
     */
    @Test
    public void whenSetArrayOneEvenThenGetReverse() {
        final int[] m = {1};
        final int[] should = {1};
        TurnArray ta = new TurnArray();
        int[] result = ta.back(m);
        assertThat(result, is(should));
    }
}