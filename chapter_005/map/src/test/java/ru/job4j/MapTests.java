package ru.job4j;

import org.junit.Test;

import java.util.*;

/**
 * Created by Anton on 26.05.2017.
 */
public class MapTests {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        User user1 = new User("One", 5, new GregorianCalendar(1970, 0, 0));
        User user2 = new User("One", 5, new GregorianCalendar(1970, 0, 0));
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(user1.equals(user2));

        System.out.println(user1.hashCode());
        System.out.println(user1.hashCode());

        for (Object ob : map.values()) {
            System.out.println(ob.toString());
        }
    }
}
