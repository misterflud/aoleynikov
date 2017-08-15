package ru.job4j;

/**
 * Created by Anton on 19.04.2017.
 */
public class User {
    /**
     * Id.
     */
    private int id;
    /**
     * Name.
     */
    private String name;
    /**
     * City.
     */
    private String city;

    /**
     * Constructor.
     * @param id id
     * @param name name
     * @param city city
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Gets id.
     * @return id
     */
    public int getId() {
        return id;
    }
}
