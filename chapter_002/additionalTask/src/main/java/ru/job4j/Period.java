package ru.job4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Anton on 26.04.2017.
 */
public class Period{
    /**
     * Count of visitors.
     */
    private int countVisitors = 0;
    /**
     * Begin of segment of work's time.
     */
    private GregorianCalendar start;
    /**
     * End of segment of work's time.
     */
    private GregorianCalendar stop;

    /**
     * Constructor.
     * @param start begin of segment of work's time
     * @param stop end of segment of work's time
     */
    public Period(GregorianCalendar start, GregorianCalendar stop) {
        this.start = start;
        this.stop = stop;

    }

    /**
     * Counts visitors.
     * @param visitors visitors
     */
    public void addVisitors(ArrayList<Visitor> visitors) {
        for (Visitor it : visitors) {
            addVisitors(it);
        }
    }

    /**
     * Counts visitors.
     * @param visitor visitor
     */
    public void addVisitors(Visitor visitor) {
        if ((start.compareTo(visitor.getExit()) <= 0 && stop.compareTo(visitor.getExit()) > 0)
                || (start.compareTo(visitor.getEnter()) >= 0 && stop.compareTo(visitor.getEnter()) < 0)
                || (start.compareTo(visitor.getEnter()) >= 0 && stop.compareTo(visitor.getExit()) < 0)) { //вот так вот непросто перечисляются все варианты. Можно немного проще
            countVisitors++;
        }
    }

    /**
     * Gets information.
     * @return String
     */
    public String information() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return String.format("Интервал времени %s - %s, Количество посетителей %s", sdf.format(start.getTime()), sdf.format(stop.getTime()), countVisitors);
    }

    /**
     * Getter.
     * @return countVisitors
     */
    public int getCountVisitors() {
        return countVisitors;
    }
}
