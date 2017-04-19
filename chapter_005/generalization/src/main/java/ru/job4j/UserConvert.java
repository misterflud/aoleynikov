package ru.job4j;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Anton on 19.04.2017.
 */
public class UserConvert {
    /**
     * Adds User in map.
     * @param list of Users
     * @return Map of Users
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User iter : list) {
            map.put(iter.getId(), iter);
        }
        return map;
    }
}


