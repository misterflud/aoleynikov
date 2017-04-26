package ru.job4j;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Anton on 26.04.2017.
 */
public class CreatePeople {
    /**
     * Generator of men.
     * @return People's list
     */
    public ArrayList<Visitor> getPeople() {
        ArrayList<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor(new GregorianCalendar(2017, 3, 26, 10, 0), new GregorianCalendar(2017, 3, 26, 10, 30)));
        visitors.add(new Visitor(new GregorianCalendar(2017, 3, 26, 10, 0), new GregorianCalendar(2017, 3, 26, 10, 30)));
        visitors.add(new Visitor(new GregorianCalendar(2017, 3, 26, 10, 0), new GregorianCalendar(2017, 3, 26, 10, 30)));
        visitors.add(new Visitor(new GregorianCalendar(2017, 3, 26, 10, 0), new GregorianCalendar(2017, 3, 26, 10, 30)));
        visitors.add(new Visitor(new GregorianCalendar(2017, 3, 26, 19, 0), new GregorianCalendar(2017, 3, 26, 19, 30)));
        visitors.add(new Visitor(new GregorianCalendar(2017, 3, 26, 19, 0), new GregorianCalendar(2017, 3, 26, 19, 30)));

        return visitors;
    }
}
