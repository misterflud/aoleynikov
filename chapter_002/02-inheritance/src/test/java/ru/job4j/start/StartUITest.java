package ru.job4j.start;

import org.junit.Test;
import ru.job4j.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**For tests.
 *@author Anton Oleynikov
 *@version 1
 */
public class StartUITest {
    /**
     * Test1 add.
     * @throws Exception Exception
     */
    @Test
    public void whenSetAnswersThenReturnSomething() throws Exception {
        StubInput stubInput = new StubInput(new String[]{"0", "DD", "11", "n", "0", "DD", "22", "n", "0", "YY", "yy", "n", "1", "n",  "4", "DD", "y"});
        //Tracker tracker = new Tracker();
        //StartUI startUI = new StartUI(stubInput, tracker);
        //startUI.init();
        //Item[] result = tracker.filterByName("DD");
        //assertThat(result[0].getName(), is("DD"));
    }
}
