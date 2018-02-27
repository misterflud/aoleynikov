package ru.aoleynikov.model;

import java.sql.Timestamp;

/**
 * Created by Anton on 02.07.2017.
 */
public class User extends BaseUser {
	
	
    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     * @param timeOfCreate when created
     * @param userType type 
     * @param password password
     */
    public User(String name, String login, String email, Timestamp timeOfCreate, Role userType) {
        super(name, login, email, timeOfCreate, userType);
    }
	
    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     * @param timeOfCreate when created
     * @param userType type 
     * @param password password
     */
    public User(String name, String login, String email, Timestamp timeOfCreate, Role userType, String password) {
        super(name, login, email, timeOfCreate, userType, password);
    }
    
    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     * @param timeOfCreate when created
     */
    public User(String name, String login, String email, Timestamp timeOfCreate) {
        super(name, login, email, timeOfCreate);
    }

    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     */
    public User(String name, String login, String email) {
        super(name, login, email);
    }

    /**
     * Constructor.
     */
    public User() {

    }

    /**
     * Constructor.
     * @param login login
     */
    public User(String login){
        super(login);
    }

    /**
     * Constructor.
     * @param user User
     */
    public User(User user){
        super(user);
    }
}
