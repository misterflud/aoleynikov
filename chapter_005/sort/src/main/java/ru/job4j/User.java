package ru.job4j;

/**
 * Created by Anton on 19.04.2017.
 */
public class User implements Comparable<User> {
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

    /**
     * Gets age.
     * @return age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets length of name;
     * @return length of name
     */
    public int getLengthOfName() {
        return name.length();
    }

    /**
     * Compares.
     * @param o object
     * @return a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.getAge());
    }
}
