package aoleynikov.servlets;

import java.sql.Timestamp;

/**
 * Created by Anton on 02.07.2017.
 */
public abstract class BaseUser {
    /**
     * Name user.
     */
    public String name;
    /**
     * Login.
     */
    public String login;
    /**
     * Email.
     */
    public String email;
    /**
     * When created.
     */
    public Timestamp timeOfCreate;

    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     * @param timeOfCreate when created
     */
    public BaseUser(String name, String login, String email, Timestamp timeOfCreate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.timeOfCreate = timeOfCreate;
    }

    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     */
    public BaseUser(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    /**
     * Constructor.
     */
    public BaseUser(){

    }

    /**
     * Constructor.
     * @param login login
     */
    public BaseUser(String login){
        this.login = login;
    }

    /**
     * Constructor.
     * @param user User
     */
    public BaseUser(User user){
        this.name = user.name;
        this.login = user.login;
        this.email = user.email;
        this.timeOfCreate = user.timeOfCreate;
    }
}
