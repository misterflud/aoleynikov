package ru.job4j.testtask;


/**
 * Created by Anton on 23.02.2017.
 */
public class TwoMass {
    /**
     *
     * @param mass1 mass
     * @param mass2 mass
     * @return mass
     */
    public int[] concatenation(int[] mass1, int[] mass2) {
        int[] result = new int[mass1.length + mass2.length - 2];
        int iter1 = 0;
        int iter2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (iter1 == mass1.length) {
                result[i] = mass2[iter2];
                iter2++;
            } else if (iter2 == mass2.length) {
                result[i] = mass2[iter1];
                iter1++;
            } else {
                if (mass1[iter1] < mass2[iter2]) {
                    result[i] = mass1[iter1];
                    iter1++;
                } else {
                    result[i] = mass1[iter2];
                    iter2++;
                }
            }
        }
        return result;
    }
}
