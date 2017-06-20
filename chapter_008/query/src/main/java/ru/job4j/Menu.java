package ru.job4j;

import java.util.ArrayList;

/**
 * Created by Anton on 20.06.2017.
 */
public class Menu {

    private Connect connect;

    private FilterManager filterManager;

    private ArrayList<Action> actionList = new ArrayList<>();

    public Menu(Connect connect, FilterManager filterManager) {
        this.connect = connect;
        this.filterManager = filterManager;
        fillActionList();
    }

    private void fillActionList() {

    }

    public void getActions() {
        for (Action it : actionList) {
            connect.sendAnswer(it.getDescription());
        }

    }

    class SelectFilter extends BaseAction {

        public SelectFilter(int number) {
            super(number);
        }

        @Override
        public void execute() {

        }

        @Override
        public String getDescription() {
            return String.format("%s %s", number, "select for using filter");
        }
    }

    class AddFilter extends BaseAction {

        public AddFilter(int number) {
            super(number);
        }

        @Override
        public void execute() {

        }

        @Override
        public String getDescription() {
            return String.format("%s %s", number, "create new filter");
        }
    }
}
