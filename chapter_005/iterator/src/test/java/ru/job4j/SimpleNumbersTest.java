package ru.job4j;

import org.junit.Test;

/**
 * Created by Anton on 03.05.2017.
 */
public class SimpleNumbersTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        final int[] mass = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        SimpleNumbers simpleNumbers = new SimpleNumbers(mass);
        final int wait = 5;
        while(simpleNumbers.hasNext()) {
            System.out.println((int) simpleNumbers.next());
        }
        /*
        simpleNumbers.next();
        simpleNumbers.next();
         */

        //assertThat(wait, is(simpleNumbers.next()));
    }
}
