package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 03.05.2017.
 */
public class SimpleArrayTest {
    /**
     * Test.
     */
    @Test
    public void whenDeleteThenMassBecomeLess() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);


        simpleArray.delete(1);
        simpleArray.update();

        final int wait = 3;

        assertThat(simpleArray.get(1), is(wait));

    }


}
