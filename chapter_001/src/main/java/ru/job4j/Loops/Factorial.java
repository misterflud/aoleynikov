package ru.job4j.loops;

/**Counting factorial.
 *@author Anton Oleynikov
 *@version 1
 */
public class Factorial {
    /**
     *@param max max
     *@return count count
     */
    public int fac(int max) {
        int count = 1;
        for (int i = 2; i <= max; i++) {
            count = count * i;
        }
        return count;
    }
}