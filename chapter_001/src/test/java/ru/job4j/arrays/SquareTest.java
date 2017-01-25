package ru.job4j.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**Test Square.
 *@author Anton Oleynikov
 *version 1
 */
public class SquareTest {
    /**
     *Test.
     */
    @Test
    public void whenSetArrayOddThenGetReverse() {
        final int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int[][] should = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        Square sq = new Square();
        int[][] result = sq.turn(m);
        assertThat(result, is(should));
    }
}