package ru.job4j;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anton on 17.04.2017.
 */
public class ConvertList {
    /**
     * Get list.
     * @param array array
     * @return List
     */
    public List<Integer> toList (int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] it1 : array) {
            for (int it2 : it1) {
                list.add(it2);
            }
        }
        return list;
    }

    /**
     * Get mas.
     * @param list list
     * @param rows rows
     * @return mas.
     */
    public int[][] toArray (List<Integer> list, int rows) {
        int count = list.size();
        while (count % rows != 0) {
            count++;
        }
        int[][] mass = new int[count / rows][rows];

        int i = 0;
        Iterator<Integer> iterator = list.iterator();
        for (int j = 0; j < mass.length; j++) {
            for (int jj = 0; jj < mass[j].length; jj++) {
                if (iterator.hasNext()) {
                    mass[j][jj] = iterator.next();
                } else {
                    break;
                }
            }
        }
        return mass;
    }

    /**
     * Convert.
     * @param list with massifs
     * @return List of int
     */
    public List<Integer> convert (List<int[]> list) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int[] iterator : list) {
            for (int iterator2 : iterator) {
                l.add(iterator2);
            }
        }
        return l;
    }

}
