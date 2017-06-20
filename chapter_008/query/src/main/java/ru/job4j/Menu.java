package ru.job4j;

import java.util.ArrayList;

/**
 * Created by Anton on 20.06.2017.
 */
public class Menu {

    /**
     * Connection with database.
     */
    private Connect connect;

    /**
     * FilterManager.
     */
    private FilterManager filterManager;

    /**
     * List of actions.
     */
    private ArrayList<Action> actionList = new ArrayList<>();

    /**
     * Constructor.
     * @param connect connect
     * @param filterManager filterManager
     */
    public Menu(Connect connect, FilterManager filterManager) {
        this.connect = connect;
        this.filterManager = filterManager;
        fillActionList();
    }

    /**
     * Fills lists.
     */
    private void fillActionList() {
        actionList.add(new SelectFilter(actionList.size()));
        actionList.add(new AddFilter(actionList.size()));
    }

    /**
     * Gets action.
     */
    public void getActions() {
        for (Action it : actionList) {
            connect.sendAnswer(it.getDescription());
        }

    }

    /**
     * Executes SQL request.
     * @param num num
     */
    public void execute(int num) {
        actionList.get(num).execute();
    }

    /**
     * Selects from filter's list.
     */
    class SelectFilter extends BaseAction {

        /**
         * Constructor.
         * @param number position
         */
        public SelectFilter(int number) {
            super(number);
        }

        /**
         * Execute.
         */
        @Override
        public void execute() {
            filterManager.SelectFilter();
        }

        /**
         * Description.
         * @return description.
         */
        @Override
        public String getDescription() {
            return String.format("%s) %s", number, "Select for using filter");
        }
    }

    /**
     * Adds filter in filter's list.
     */
    class AddFilter extends BaseAction {

        /**
         * Constructor.
         * @param number position
         */
        public AddFilter(int number) {
            super(number);
        }

        /**
         * Execute.
         */
        @Override
        public void execute() {
            filterManager.AddFilter();
        }

        /**
         * Description.
         * @return description.
         */
        @Override
        public String getDescription() {
            return String.format("%s) %s", number, "Create new filter");
        }
    }
}
