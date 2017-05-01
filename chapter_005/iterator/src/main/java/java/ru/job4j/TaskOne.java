package ru.job4j;

import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Anton on 28.04.2017.
 * Необходимо создать интератор для двухмерного массива.

 int[][] value = {
 {1, 2}
 {3, 4}
 };

 метод next = должен вернуть последовательно 1, 2, 3, 4
 *
 */
public class TaskOne implements Iterator {
    /**
     * Main mass.
     */
    private int[][] array;
    /**
     *  Massive with the sizes of each insider array.
     */
    private int[] sizes;
    /**
     *  Index of massive of arrays.
     */
    private int index1 = 0; //массивы
    /**
     * Index of numbers in array.
     */
    private int index2 = 0; //числа в массиве

    /**
     * Constructor.
     * @param array array
     */
    public TaskOne(int[][] array) {
        sizes = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sizes[i] = array[i].length;
        }
        this.array = array;
    }

    /**
     * Has next?
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        boolean result = true;
        if (index1 >= sizes.length) {
            result = false;
        }
        return result;
    }

    /**
     * Gives number.
     * @return  int.
     */
    @Override
    public Object next() {
        Object object = array[index1][index2++];
        if (index2  == sizes[index1]) {
            index1++; // следующий массив
            index2 = 0;
        }
        return object;
    }
}
