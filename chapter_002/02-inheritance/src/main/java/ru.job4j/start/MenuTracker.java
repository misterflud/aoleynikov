package ru.job4j.start;

import ru.job4j.models.Item;
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
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new Filter();

    }

    /**
     * show.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     *
     * @param items items
     */
    public void print(Item[] items) {
        for (Item item : items) {
            System.out.println(String.format("%s %s %s", item.getName(), item.getDescription(), item.getId()));
        }
    }

    /**
     *
     * @param key key.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Class AddItem 1.
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
            return String.format("%s. %s", this.key(), "Add the new Item");
        }
    }

    /**
     * ShowItems 2.
     */
    private static class ShowItems implements UserAction {
        /**
         *
         * @return int
         */
        public int key() {
            return 1;
        }

        /**
         *
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        /**
         *
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all Item");
        }
    }

    /**
     * ChangeItem 4.
     */
    private class DeleteItem implements UserAction {
        /**
         *
         * @return int
         */
        public int key() {
            return 3;
        }

        /**
         *
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            tracker.delete(tracker.findById(id));
        }

        /**
         *
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete Item");
        }
    }

    /**
     * Filter 5.
     */
    private class Filter implements UserAction {
        /**
         *
         * @return int
         */
        public int key() {
            return 4;
        }

        /**
         *
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the item's name: ");
            print(tracker.filterByName(name));
        }

        /**
         *
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Filter Item");
        }
    }
}

class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id: ");
        String name = input.ask("enter the task's name: ");
        String desc = input.ask("enter the description: ");
        tracker.update(new Task(name, desc), id);
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the new item");
    }
}
