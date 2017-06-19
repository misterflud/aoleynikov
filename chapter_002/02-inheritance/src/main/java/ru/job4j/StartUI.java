package ru.job4j;
import ru.job4j.start.*;

import java.io.InputStream;
import java.util.Properties;

/**StartUI -- It is for manage the program.
 *Example '<Milk> + <12>', it's mean that you should write: Milk 12
 *@author Anton Oleynikov
 *@version 1
 */
public class StartUI {
    /**
     *input input.
     */
    private Input input;
    /**
     * Tracker.
     */
    private Tracker tracker;

    private int[] ranges = new int[] {0, 1, 2, 3, 4, 6, 7}; //нужно сделать заполнение из меню
    /**
     *Constructor.
     * @param input input
     * @param tracker tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     *@param args from console
     *@exception Exception Exception
     */
    public static void main(String[] args) throws Exception {
        Input input = new ConsoleInput();
        //Input input = new ValidateInput();
        //new StartUI(input, new Tracker()).init();



        final Properties prs = new Properties();
        ClassLoader load = StartUI.class.getClassLoader();
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
            prs.load(inputStream);
        }

        try (Tracker trackerSQL = new TrackerSQL(prs.getProperty("username"), prs.getProperty("password"), prs.getProperty("url"))) {
            new StartUI(input, trackerSQL).init();
        }
    }
    /**
     *@exception Exception Exception
     */
    public void init() throws Exception {

        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();
        UserAction deleteAction = new BaseAction("Delete") { //анонимный класс
            /**
             * @return int.
             */
            public int key() {
                return 4;
            }
            /**
             * @param input input.
             * @param tracker tracker.
             */
            public void execute(Input input, Tracker tracker){
                String id = input.ask("Please, enter the task's id: ");
                tracker.delete(tracker.findById(id));
            }
        };
        menu.addAction(deleteAction);
        do {
            menu.show();
            menu.select(input.ask("select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }
}