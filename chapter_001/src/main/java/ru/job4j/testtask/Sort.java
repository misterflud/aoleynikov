package ru.job4j.testtask;

/**
 * Created by Anton on 23.02.2017.
 */
public class Sort {
    /**
     *
     * @param mass mass
     * @return boolean
     */
    public boolean detectSort(int[] mass) {
        if (mass[0] > mass[mass.length - 1]) {
            for (int i = 0; i < mass.length - 2; i++) {
                if (mass[i] < mass[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < mass.length - 2; i++) {
                if (mass[i] > mass[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
