package ru.job4j.start;

import ru.job4j.models.Task;

/**MenuTracker.
 *@author Anton Oleynikov
 *@version 1
 */
public class MenuTracker {
    /**
     * Input.
     */
    private Input input;
    /**
     * Tracker.
     */
    private Tracker tracker;
    /**
     * final.
     */
    private final int seven = 7;
    /**
     * UserAction[].
     */
    private UserAction[] actions = new UserAction[seven];

    /**
     *
     * @param input input.
     * @param tracker tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        fillAction();
    }

    /**
     * fillAction.
     */
    public void fillAction() {
        actions[0] = new AddItem();
    }

    /**
     *
     * @param key key.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Class AddItem.
     */
    private class AddItem implements UserAction {
        /**
         *
         * @return int
         */
        public int key() {
            return 0;
        }

        /**
         *
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("enter the task's name: ");
            String desc = input.ask("enter the description: ");
            tracker.add(new Task(name, desc));
        }

        /**
         *
         * @return String.
         */
        public String info() {
            return "";
        }
    }

    /**
     * Class.
     */
    private class ChangeItem implements UserAction {
        /**
         *
         * @return int.
         */
        public int key() {
            return 2;
        }

        /**
         *
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {

        }

        /**
         *
         * @return String.
         */
        public String info() {
            return "";
        }
    }
}
