package ru.job4j.start;

import ru.job4j.models.Item;
import ru.job4j.models.Task;

import java.util.ArrayList;

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
     * UserAction.
     */
    ArrayList<UserAction> actions = new ArrayList<>();


    /**
     *
     * @param input input.
     * @param tracker tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * fillAction.
     */
    public void fillAction() {
        UserAction action1 = new AddItem();
        UserAction action2 = new MenuTracker.ShowItems();
        UserAction action3 = new EditItem();
        UserAction action4 = new Filter();
        this.actions.add(action1.key(), action1);
        this.actions.add(action2.key(), action2);
        this.actions.add(action3.key(), action3);
        this.actions.add(action4.key(), action4);
    }

    /**
     * Adds action.
     * @param action action
     */
    public void addAction(UserAction action) {
        this.actions.add(action.key(), action);
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
    public void print(ArrayList<Item> items) {
        for (Item item : items) {
            System.out.println(String.format("%s %s %s", item.getId(), item.getName(), item.getDescription()));
        }
    }

    /**
     *
     * @param key key.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Class AddItem 1.
     */
    private class AddItem extends BaseAction{
        /**
         * Constructor.
         */
        public AddItem() {
            super("Add the new Item");
        }
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
    }

    /**
     * ShowItems 2.
     */
    private static class ShowItems extends BaseAction {
        /**
         * Constructor.
         */
        public ShowItems() {
            super("Show all Item");
        }
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
                System.out.println(String.format("%s. %s %s", item.getId(), item.getName(), item.getDescription()));
            }
        }
    }

    /**
     * ChangeItem 4.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Constructor.
         */
        public DeleteItem() {
            super("Delete Item");
        }
        /**
         *
         * @return int
         */
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
    }

    /**
     * Filter 5.
     */
    private class Filter extends BaseAction {
        /**
         * Constructor.
         */
        public Filter() {
            super("Filter Item");
        }
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
            String name = input.ask("Please, enter the item's name: ");
            print(tracker.filterByName(name));
        }
    }
}

class EditItem extends BaseAction {
    /**
     * Constructor.
     */
    public EditItem() {
        super("Edit the item");
    }
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

}
