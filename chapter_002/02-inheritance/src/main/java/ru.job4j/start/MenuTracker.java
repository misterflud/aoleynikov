package ru.job4j.start;

/**
 * Don't use.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        fillAction();
    }

    public void fillAction() {
        actions[0] = new AddItem();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    private class AddItem implements UserAction {

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {

        }

        public String info() {
            return "";
        }
    }
    private class ChangeItem implements UserAction {

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {

        }

        public String info() {
            return "";
        }
    }
}
