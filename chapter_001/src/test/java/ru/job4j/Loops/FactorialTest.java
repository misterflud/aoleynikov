package ru.job4j.loops;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**Test factorial.
 *@author Anton Oleynikov
 *@version 1
 */
public class FactorialTest {
    /**
     *Test.
     */
    @Test
    public void whenSetNumberThenGetFactorial() {
        final int number = 4;
        final int should = 24;
        Factorial fact = new Factorial();
        int result = fact.fac(number);
        assertThat(result, is(should));
    }
}