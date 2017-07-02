package aoleynikov.servlets;

import java.sql.Timestamp;

/**
 * Created by Anton on 02.07.2017.
 */
public class User extends BaseUser {
    public User(String name, String login, String email, Timestamp timeOfCreate) {
        super(name, login, email, timeOfCreate);
    }

    public User(String name, String login, String email) {
        super(name, login, email);
    }

    public User(){

    }

    public User(String login){
        super(login);
    }
}
