package ru.job4j;

import java.util.GregorianCalendar;

/**
 * Created by Anton on 26.04.2017.
 */
public class Visitor {
    /**
     * Enter's time.
     */
    private GregorianCalendar enter;
    /**
     * Exit's time.
     */
    private GregorianCalendar exit;

    /**
     * Constructor.
     * @param enter enter
     * @param exit exit
     */
    public Visitor(GregorianCalendar enter, GregorianCalendar exit) {
        this.enter = enter;
        this.exit = exit;
    }

    /**
     * Getter.
     * @return time
     */
    public GregorianCalendar getEnter() {
        return this.enter;
    }
    /**
     * Getter.
     * @return time
     */
    public GregorianCalendar getExit() {
        return this.exit;
    }
}
