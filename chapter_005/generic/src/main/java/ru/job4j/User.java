package ru.job4j;

import java.util.Date;

/**
 * Created by Anton on 06.05.2017.
 */
public class User extends Base {

    /**
     * Gets id.
     * @return Id
     */
    @Override
    public String getId() {
        return super.id;
    }

    /**
     * Sets Id.
     */
    @Override
    public  void  setId() {
        Date date = new Date();
        super.id = "U"  + String.valueOf((int) date.getTime());
    }


}
