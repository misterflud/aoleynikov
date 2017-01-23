package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**This is ClassTests.
 * @author Anton Oleynikov
 * @version 1
 */
public class CalculatorTest {
    /**
     * Test1 add.
     */
    @Test
    public void whenSetFirst1AndSecond1ThenReturnResult1() {
        Calculator cl = new Calculator();
        final double first1 = 5;
        final double second1 = 5;
        final double ten = 10;
        cl.add(first1, second1);
        double result = cl.getResult();
        assertThat(result, is(ten));
    }
    /**
     * Test2 add.
     */
    @Test
    public void whenSetFirst2AndSecond2ThenReturnResult2() {
        Calculator cl = new Calculator();
        final double first2 = 4;
        final double second2 = 4;
        final double eight = 8;
        cl.add(first2, second2);
        double result = cl.getResult();
        assertThat(result, is(eight));
    }
}