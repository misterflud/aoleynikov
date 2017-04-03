package ru.job4j;

/**
 * Created by Anton on 03.04.2017.
 */
public class SubMenu2 extends SubMenu {
    /**
     * Constructor.
     */
    public SubMenu2() {

    }
    /**
     * adding action in ArrayList.
     */
    @Override
    protected void fillActionList() {
      super.fillActionList();
      actionList.add(new Cos());
      actionList.add(new Sin());
    }

    /**
     * Cos().
     */
    public class Cos implements Action {

        @Override
        public String information() {
            return "Cos()";
        }

        @Override
        public void execute() {
            Calculator2 calculator2 = new Calculator2();
            calculator2.cos(fillParameter());
            result = calculator2.getResult();
        }
    }

    /**
     * Sin().
     */
    public class Sin implements Action {

        @Override
        public String information() {
            return "Sin()";
        }

        @Override
        public void execute() {
            Calculator2 calculator2 = new Calculator2();
            calculator2.sin(fillParameter());
            result = calculator2.getResult();
        }
    }
}
