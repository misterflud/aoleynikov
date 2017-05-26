package ru.job4j;

import java.util.Calendar;

/**
 * Created by Anton on 26.05.2017.
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Children.
     */
    private int children;
    /**
     * Birthday.
     */
    private Calendar birthday;

    /**
     *
     * @param name name
     * @param children how many
     * @param birthday when
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
