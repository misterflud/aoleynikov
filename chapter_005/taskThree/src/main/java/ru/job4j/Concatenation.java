package ru.job4j;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Anton on 10.06.2017.
 * соединить 2 массива -- один отсортированный, другой нет.
 */
public class Concatenation {

    /**
     * Concatenation.
     * @param mass1 sorted
     * @param mass2 not sorted
     * @return mass
     */
    public int[] concat(int[] mass1, int[] mass2) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (Integer iter : mass2) {
            treeSet.add(iter);
        }
        for (Integer iter : mass1) {
            treeSet.add(iter);
        }
        int[] result = new int[treeSet.size()];
        int i = 0;
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            result[i++] = iterator.next();
        }

        return result;
    }

}
