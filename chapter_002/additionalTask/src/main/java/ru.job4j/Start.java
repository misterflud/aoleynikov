package ru.job4j;

import java.util.GregorianCalendar;

/**
 * Created by Anton on 26.04.2017.
 *  * Created by Anton on 25.04.2017.
 * В течении дня в банк заходят люди, у каждого человека есть время захода в банк и время выхода.<br>
 * Всего за день у банка было N посетителей. Банк работает с 8:00 до 20:00.<br>
 * Человек посещает банк только один раз за день.<br>
 * Написать программу, которая определяет периоды времени,<br>
 * когда в банке было максимальное количество посетителей.<br>
 */
public class Start {
    /**
     * Main.
     * @param args args
     */
    public static void main(String[] args) {
        Start start = new Start();
        start.startProgram();
    }

    /**
     * Start program.
     */
    public void startProgram() {
        CreatePeople createPeople = new CreatePeople();
        //Можно менять: интервал времени, рабочее время банка -- кол-во посетителей посчитается в промежутке времени В ЛЮБОМ СЛУЧАЕ
        Bank bank = new Bank(1, new GregorianCalendar(2017, 3, 26, 8, 0), new GregorianCalendar(2017, 3, 26, 20, 0));
        bank.addVisitor(createPeople.getPeople());
        bank.calculate();

        System.out.println(bank.getBusyPeriod().information());
    }
}
