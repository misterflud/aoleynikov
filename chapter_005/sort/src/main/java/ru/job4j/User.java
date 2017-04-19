package ru.job4j;

import java.util.Comparator;

/**
 * Created by Anton on 19.04.2017.
 */
public class User implements Comparable<User>, Comparator {
    /**
     * Name.
     */
    private String name;
    /**
     * Age.
     */
    private int age;

    /**
     * Constructor.
     * @param name name
     * @param age age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    /**
     * Compares.
     * @param o object
     * @return a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(User o) {
        int result;
        if (this.age > o.getAge()) {
            result = 1;
        } else if (this.age < o.getAge()) {
            result = -1;
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * Compare.
     * @param o1 o1
     * @param o2 o2
     * @return -1, 0, 1
     */
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
