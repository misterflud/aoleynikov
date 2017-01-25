package ru.job4j.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**Test Duplicate.
 *@author Anton Oleynikov
 *version 1
 */
public class DuplicateTest {
    /**
     *Test.
     */
    @Test
    public void whenSetStringArrayThenGetWhithoutDuplicate() {
        final String[] m = {"Hi", "Hi", "Peace", "Peace", "Java"};
        final String[] should = {"Hi", "Peace", "Java"};
        Duplicate dup = new Duplicate();
        String[] result = dup.del(m);
        assertThat(result, is(should));
    }
}