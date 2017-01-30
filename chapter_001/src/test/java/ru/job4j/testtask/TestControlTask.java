package ru.job4j.testtask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Testing TestTask class's.
 *@author Anton Oleynikov
 *version 1
 */
public class TestControlTask {
    /**Test add.*/
    @Test
    public void whenSetTwoStringThenGetContaintsItOrNot() {
        final String origin = "abcasasassasasasf";
        final String sub = "abc";
        final boolean bul = true;
        ControlTask task = new ControlTask();
        boolean result = task.contains(origin, sub);
        assertThat(result, is(true));
    }
}