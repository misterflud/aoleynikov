package ru.job4j.arrays;

/**Reversing numbers in array.
 *@author Anton Oleynikov
 *version 1
 */
public class TurnArray {
    /**
     *@param m array
     *@return m reversMass
     */
    public int[] back(int[] m) {
        int begin;
        int len = m.length;
        for (int i = 0; i < len / 2; i++) {
            begin = m[i];
            m[i] = m[len - i - 1];
            m[len - i - 1] = begin;
        }
        return m;
    }
}