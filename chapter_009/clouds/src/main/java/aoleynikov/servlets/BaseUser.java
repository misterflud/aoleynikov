package aoleynikov.servlets;

import java.sql.Timestamp;

/**
 * Created by Anton on 02.07.2017.
 */
public abstract class BaseUser {
    String name;

    String login;

    String email;

    Timestamp timeOfCreate;


    public BaseUser(String name, String login, String email, Timestamp timeOfCreate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.timeOfCreate = timeOfCreate;
    }

    public BaseUser(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public BaseUser(){

    }
}
