package ru.job4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anton on 19.04.2017.
 */
public class UserConvert {

    public static void main(String[] args) {
        UserConvert userConvert = new UserConvert();
        LinkedList<User> list = new LinkedList<User>();
        for (int i = 0; i < 10; i++) {
            list.add(new User(i, ((Integer) i).toString(), ((Integer) i).toString()));
        }
        System.out.println(userConvert.process(list).size());
    }

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User iter : list) {
            map.put(iter.getId(), iter);
        }
        return map;
    }
}


