package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateTest {
    @Test
    public void whenSetStopThenReturnThreeStops() {
        Calculate cl = new Calculate();
        String result = cl.echo("stop");
        assertThat(result, is("stop stop stop"));
    }

    @Test
    public void whenSetNullInEchoReturnTwoSpaces() {//неправильный тест
        Calculate cl = new Calculate();
        String result = cl.echo(null);
        assertThat(result, is("null null null"));
    }
}


