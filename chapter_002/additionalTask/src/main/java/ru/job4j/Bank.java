package ru.job4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Created by Anton on 26.04.2017.
 */
public class Bank {
    /**
     * List visitors.
     */
    private ArrayList<Visitor> visitors = new ArrayList<>();
    /**
     *  List periods.
     */
    private ArrayList<Period> periods = new ArrayList<>();

    /**
     * Constructor.
     * @param partsOfTime on how many parts we will divide work Time of Bank
     * @param startWork time
     * @param endWork time
     */
    public Bank(int partsOfTime, GregorianCalendar startWork, GregorianCalendar endWork) {
        divideTime(partsOfTime, startWork, endWork);
    }

    /**
     * Divides time on periods.
     * @param partsOfTime on how many parts we will divide work Time of Bank
     * @param startWork time
     * @param endWork time
     */
    private void divideTime(int partsOfTime, GregorianCalendar startWork, GregorianCalendar endWork) { //самое важное -- разбитие на части рабочее время
        long time = (endWork.getTimeInMillis() - startWork.getTimeInMillis()) / partsOfTime; //делим рабочее время на промежутки

        for (int i = 0; i < partsOfTime; i++) { //возможно упустим последний промежуток -- с временем работать тяжко
            GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar1.setTimeInMillis(startWork.getTimeInMillis() + time * ((long) i));
            gregorianCalendar2.setTimeInMillis(startWork.getTimeInMillis() + time * ((long) i + 1));
            periods.add(new Period(gregorianCalendar1, gregorianCalendar2)); //заполняем список периодами
        }
    }

    /**
     * Adds visitors.
     * @param visitors visitors
     */
    public void addVisitor(ArrayList<Visitor> visitors) {
        this.visitors.addAll(visitors);
    }

    /**
     * Adds visitor.
     * @param visitor visitor
     */
    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
    }

    /**
     * Calculates countVisitors.
     */
    public void calculate() { //расчет принадлежности к каждому отрезку времени
        for (Period it : periods) {
            it.addVisitors(visitors);
        }

    }

    /**
     * Gets the busiest period.
     * @return the busiest period
     */
    public Period getBusyPeriod() {

        for (Period it : periods) {
            System.out.println(it.information()); //можно это убрать. Добавил для интерактивности
        }
        System.out.println("---------------------------------");

        periods.sort(new Comparator<Period>() {
            @Override
            public int compare(Period o1, Period o2) {
                return Integer.compare(o1.getCountVisitors(), o2.getCountVisitors());
            }
        });
        return periods.get(periods.size() - 1);
    }

}
