package ru.job4j.start;

/**
 * Created by Anton on 01.02.2017.
 */
public class StartUITest {
    /**
     *@param args from console
     *@exception Exception
     */
    public static void main(String[] args) throws Exception {
        new StartUI(
                new StubInput(new String[]{"asd"})
        ).init();
    }
}
