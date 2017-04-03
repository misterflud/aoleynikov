package ru.job4j;

import java.util.ArrayList;

/**
 * Created by Anton on 01.04.2017.
 * Calculator with menu
 */
public class SubMenu {
    /**
     * Class ask.
     */
    private Ask ask = new Ask();
    /**
     * The result is saved in memory.
     */
    private double memory;
    /**
     * Saving result after calculate.
     */
    private double result = 0;
    /**
     * It's contenting all our action.
     */
    private ArrayList<Action> actionList = new ArrayList<>();
    /**
     * Class Calculator (Math operation).
     */
    private Calculator calculator;

    /**
     *
     * @param calculator we can add any calculator and after that modify our SubMenu.
     */
    public SubMenu(Calculator calculator) {
        fillActionList();
        this.calculator = calculator;
    }

    /**
     * Printing action and their number.
     */
    public void printAction() {
        System.out.println(result); //не совсем подходящее место
        for (int i = 0; i < actionList.size(); i++) {
            System.out.println(String.format("%s. %s", i + 1, actionList.get(i).information()));
        }
    }

    /**
     * Select action (selecting is used in InteractCalc).
     * @param numberOfAction It's number from ArrayList
     */
    public void selectAction(String numberOfAction) {
        int numberAction = Integer.parseInt(numberOfAction) - 1;
        actionList.get(numberAction).execute();
    }

    /**
     * adding action in ArrayList.
     */
    private void fillActionList() {
        actionList.add(new SaveResultInMemory());
        actionList.add(new Sum());
        actionList.add(new Substruct());
        actionList.add(new Div());
        actionList.add(new Multiple());
    }

    /**
     * It gets numbers from user.
     * @return what entered user.
     */
    private double fillParameter() { //для заполнения параметров
        String answer = ask.ask("Введите число или напишите <m>: ");
        double param = -1;
        if ("m".equals(answer)) {
            param = memory;
        } else {
            param = Double.parseDouble(answer);
        }
        return param;
    }

    /**
     * Saving the result in memory.
     */
    public class SaveResultInMemory implements Action {

        @Override
        public String information() {
            return "Записать в память результат";
        }

        @Override
        public void execute() {
            memory = result;
        }
    }

    /**
     * Sum.
     */
    public class Sum implements Action {

        @Override
        public String information() {
            return "Сумма";
        }

        @Override
        public void execute() {
            calculator.add(fillParameter(), fillParameter());
            result = calculator.getResult();
        }
    }

    /**
     * Substruct.
     */
    public class Substruct implements Action {
        @Override
        public String information() {
            return "Вычитание";
        }

        @Override
        public void execute() {
            calculator.substruct(fillParameter(), fillParameter());
            result = calculator.getResult();
        }
    }

    /**
     * Div.
     */
    public class Div implements Action {
        @Override
        public String information() {
            return "Деление";
        }

        @Override
        public void execute() {
            calculator.div(fillParameter(), fillParameter());
            result = calculator.getResult();
        }
    }

    /**
     * Multiple.
     */
    public class Multiple implements Action {
        @Override
        public String information() {
            return "Умножение";
        }

        @Override
        public void execute() {
            calculator.multiple(fillParameter(), fillParameter());
            result = calculator.getResult();
        }
    }

}
