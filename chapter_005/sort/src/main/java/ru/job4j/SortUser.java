package ru.job4j;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        //list.sort(User::compareTo); можно по идее так отсортировать, если реализовать Comparator
        TreeSet<User> tree = new TreeSet<>();
        for (User iter : list) {
            tree.add(iter);
        }
        return tree;
    }
}
