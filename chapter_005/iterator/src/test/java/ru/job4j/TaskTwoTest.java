package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 30.04.2017.
 */
public class TaskTwoTest {
    /**
     * Test/
     */
    @Test
    public void whenThen() {
        final int[] mass = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TaskTwo taskTwo = new TaskTwo(mass);
        final int wait = 10;
        //while(taskTwo.hasNext()) {
            //System.out.println(taskTwo.next());
        //}
        taskTwo.next();
        taskTwo.next();
        taskTwo.next();
        taskTwo.next();

        assertThat(wait, is(taskTwo.next()));
    }
}
