package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 30.04.2017.
 */
public class TaskTwo implements Iterator {
    /**
     * Main mass.
     */
    private int[] mass;
    /**
     * Result.
     */
    private int result = -1;
    /**
     * Length of mass.
     */
    private int len;
    /**
     * Iterator.
     */
    private int iterator = 0;

    /**
     * Constructor.
     * @param mass mass
     */
    public TaskTwo(int[] mass) {
        this.mass = mass;
        len = mass.length;
    }

    /**
     * Has next?
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        int iterator2 = iterator + 1;
        if (iterator2 >= len) {
            return false;
        }
        if(mass[iterator2] % 2 != 0) {
            iterator++;
            hasNext();
        }
        return true;
    }

    /**
     * Gives number.
     * @return  int.
     */
    @Override
    public Object next() {
        //System.out.println("     " + result);
        if (mass[iterator++] % 2 != 0) {
            //System.out.println(".  " + result);
            next();
        } else {
            result = mass[iterator - 1];
        }
        return result;
    }
}
