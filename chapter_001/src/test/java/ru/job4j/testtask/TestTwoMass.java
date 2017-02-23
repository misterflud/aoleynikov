package ru.job4j.testtask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Anton on 23.02.2017.
 */
public class TestTwoMass {
    /**
     * Test.
     */
    @Test
    public void whenSetTwoMassThenGetOne() {
        final int[] mass1 = {1, 2, 5, 10};
        final int[] mass2 = {3, 4, 11};
        final int[] right = {1, 2, 3, 4, 5, 10, 11};
        TwoMass twoMass = new TwoMass();
        int[] result = twoMass.concatenation(mass1, mass2);
        assertThat(result, is(result));
    }
}
