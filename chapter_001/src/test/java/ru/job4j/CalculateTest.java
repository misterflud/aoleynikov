package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**This is ClassTests.
 * @author Anton
 * @version 2
 */
public class CalculateTest {
    /**
     * Test1 add.
     */
    @Test
    public void whenSetStopThenReturnThreeStops() {
        Calculate cl = new Calculate();
        String result = cl.echo("stop");
        assertThat(result, is("stop stop stop"));
    }
    /**
     * Test2 add.
     */
    @Test
    public void whenSetNullInEchoReturnTwoSpaces() {
        Calculate cl = new Calculate();
        String result = cl.echo(null);
        assertThat(result, is("null null null"));
    }
}


