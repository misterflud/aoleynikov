package ru.job4j;

import org.junit.Test;

/**
 * Created by Anton on 10.06.2017.
 */
public class ConcatenationTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        int[] mass1 = {1, 4, 5, 9, 11};
        int[] mass2 = {3, 0, 2, 7, 6};
        Concatenation concatenation = new Concatenation();
        int[] result = concatenation.concat(mass1, mass2);
        for (Integer iter : result)
        System.out.println(iter);
    }
}
