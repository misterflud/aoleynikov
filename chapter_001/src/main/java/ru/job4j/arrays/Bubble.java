package ru.job4j.arrays;

/**Bubble's sort.
 *@author Anton Oleynikov
 *version 1
 */
public class Bubble {
    /**
     *@param m array
     *@return m reversMass
     */
    public int[] sort(int[] m) {
        int tmp;
        int len = m.length;
        int sorted = 0;
        for (int j = 0; j < len - 1; j++) {
            for (int i = 0; i < len - 1 - sorted; i++) {
                if (m[i] > m[i + 1]) {
                    tmp = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = tmp;
                }
            }
            sorted += 1;
        }
        return m;
    }
}