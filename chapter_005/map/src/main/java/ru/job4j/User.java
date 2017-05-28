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

    /**
     * HashCode.
     * @return int
     */
    @Override
    public int hashCode() {
        return 37 * name.hashCode() + children + 37 * birthday.hashCode();
    }

    /**
     * Equals.
     * @param ob object
     * @return true or false
     */
    @Override
    public boolean equals(Object ob) {
        if (ob instanceof User) {
            User user2 = (User) ob;
            if (this.name.equals(user2.name) && this.birthday.equals(user2.birthday) && this.children == user2.children) {
                return true;
            }
        }
        return false;
    }
}
