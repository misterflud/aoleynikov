package ru.job4j.loops;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**Test for Counter class.
 *@author Anton Oleynikov
 *version 1
 */
public class CounterTest {
    /**
     *Test add.
     */
    @Test
    public void whenSetTwoParamsThenCountingEvens() {
        final int start = 1;
        final int finish = 10;
        final int should = 20;
        Counter cn = new Counter();
        int result = cn.add(start, finish);
        assertThat(result, is(should));
    }
}