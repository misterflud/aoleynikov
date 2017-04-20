package ru.job4j;

import java.util.*;

/**
 * Created by Anton on 19.04.2017.
 */
public class SortUser {
    /**
     * Sorts.
     * @param list of User
     * @return TreeSet
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> tree = new TreeSet<>();
        for (User iter : list) {
            tree.add(iter);
        }
        return tree;
    }

    /**
     *
     * Sorts.
     * @param list list
     * @return sorted list
     */
    public List<User> sortHash (List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        });
        return list;
    }

    /**
     * Sorts.
     * @param list list
     * @return sorted list
     */
    public List<User> sortLength (List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getLengthOfName(), o2.getLengthOfName());
            }
        });
        return list;
    }

}
