package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Anton on 16.02.2017.
 */
public class NumberTest {
    /**
     *
     * Test1.
     * @throws Exception Exception
     */
    @Test
    public void whenSetTwoThenReturnTrue() throws Exception {
        Number number = new Number();
        final byte[] two = {2};
        boolean result = false;
        try (ByteArrayInputStream  bytes = new ByteArrayInputStream(two)) {
            result = number.isNumber(bytes);
        }
        assertThat(result, is(true));
    }
}
