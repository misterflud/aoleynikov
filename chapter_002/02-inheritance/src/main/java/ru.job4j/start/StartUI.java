package ru.job4j.start;
import ru.job4j.models.Item;
import ru.job4j.models.Task;

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
        new StartUI(input, new Tracker()).init();
    }
    /**
     *@exception Exception Exception
     */
    public void init() throws Exception {
        while (true) {
            System.out.printf("1 Add %n 2 update %n 3 delete %n 4 findAll %n 5 filterByName %n 6 findById %n 7 End");
            //System.out.printf("1 Add %n 2 update %n 3 delete %n 7 End");
            String answer = input.ask("Write number ");
            if (answer.equals("1")) {
                this.tracker.add(new Task(input.ask("enter the task's name: "), input.ask("enter description: ")));
            } else if (answer.equals("2")) {
                this.tracker.update(new Task(input.ask("enter the task's name: "), input.ask("enter description: ")), input.ask("write id: "));
            } else if (answer.equals("3")) {
                this.tracker.delete(this.tracker.findById(input.ask("write id: ")));

            } else if (answer.equals("4")) {
                print(this.tracker.findAll());
            } else if (answer.equals("5")) {
                print(this.tracker.filterByName(input.ask("write name: ")));
            } else if (answer.equals("6")) {
                print(this.tracker.findById(input.ask("write id: ")));

            } else if (answer.equals("7")) {
                break;
            }
        }
    }
    /**
     *
     * @param items items.
     */
    public void print(Item[] items) {
        for (Item item : items) {
            System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
        }
    }

    /**
     *
     * @param item item.
     */
    public void print(Item item) {
        System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
    }
}