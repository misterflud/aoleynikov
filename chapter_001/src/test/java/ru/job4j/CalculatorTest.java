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
     * Test add.
     */
    @Test
    public void whenSetFirst1AndSecond1ThenReturnResult1() {
        Calculator cl = new Calculator();
        final double first1 = 5;
        final double second1 = 5;
        final double fifteen = 15;
        cl.add(first1, second1);
        double add = cl.getResult();
        cl.div(add, second1);
        double div = cl.getResult();
        cl.substruct(second1, div);
        double substruct = cl.getResult();
        cl.multiple(substruct, second1);
        double multiple = cl.getResult();
        double result = multiple;
        assertThat(result, is(fifteen));
    }
}