package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 02.05.2017.
 */
public class SimpleNumbers implements Iterator {
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
    private int iterator = -1;
    /**
     * Returns.
     */
    private boolean ret;

    /**
     * Constructor.
     * @param mass mass
     */
    public SimpleNumbers(int[] mass) {
        this.mass = mass;
        len = mass.length;
    }

    /**
     * Has next?
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        ret = true;
        int iterator2 = iterator + 1;
        if (iterator2 >= len) {
            ret = false; // вот таким вот странным образом приходится получать нужные данные из рекурсии, почему то return не останавливает ее
            return false;
        }
        if (mass[iterator2] <= 1) {
            iterator++;
            hasNext();
        }
        for (int i = 2; i < mass[iterator2] - 1; i++) {
            if (mass[iterator2] % i == 0 && mass[iterator2] != 2) {
                iterator++;
                hasNext();
                break;
            }
        }
        return ret;
    }

    /**
     * Gives number.
     * @return  int.
     */
    @Override
    public Object next() {
        iterator++;
        if (mass[iterator] <= 1) {
            next();
        }
        for (int i = 2; i < mass[iterator] - 1; i++) {
            if (mass[iterator] % i == 0 && mass[iterator] != 2) {
                hasNext();
                break;
            }
        }
        result = mass[iterator];
        return result;
    }
}
