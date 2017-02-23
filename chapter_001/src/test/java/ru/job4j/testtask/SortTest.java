package ru.job4j.testtask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 23.02.2017.
 */
public class SortTest {
    /**
     * Test add.
     */
    @Test
    public void whenGiveMassiveThatGetSortItOrNot() {
        final int[] mass = {1, 2, 4, 5, 10};
        Sort sort = new Sort();
        boolean result = sort.detectSort(mass);
        assertThat(result, is(true));
    }
}
