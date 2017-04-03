package ru.job4j;


/**
 * Created by Anton on 22.03.2017.
 * Start program.
 */
public class InteractCalc {
    /**
     * Start point.
     * @param args console.
     */
    public static void main(String[] args) {
        InteractCalc interactCalc = new InteractCalc();
        interactCalc.startProgram();
    }

    /**
     * Second start point.
     */
    public void startProgram() {
        SubMenu2 subMenu = new SubMenu2();
        Ask ask = new Ask();
        do {
            subMenu.printAction();
            subMenu.selectAction(ask.ask("Введите номер операции: "));
        } while (true);
    }
}
