package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 29.04.2017.
 */
public class TaskOneTest {
    /**
     * Test.
     */
    @Test
    public void whenUseNextThenGetNextNumber() {
        int[][] value = {{1, 2}, {3, 4, 7}};
        TaskOne taskOne = new TaskOne(value);
        taskOne.next();
        taskOne.next();
        taskOne.next();
        taskOne.next();
        final int wait = 7;
        System.out.println(taskOne.hasNext());
        assertThat(wait, is(taskOne.next()));
        System.out.println(taskOne.hasNext());
    }
}
