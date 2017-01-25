package ru.job4j.arrays;

/**Turning on 90 graduses array.
 *@author Anton Oleynikov
 *version 1
 */
public class Square {
    /**
     *@param m array
     *@return m turned array
     */
    public int[][] turn(int[][] m) {
        int tmp;
        int len = m.length;
        TurnArray ta = new TurnArray();
        int count = 0;
        int j;
        for (int i = 0; i < len; i++) {
            m[i] = ta.back(m[i]);
        }
        for (int i = 0; i < len; i++) {
            j = count;
            for (; j < len; j++) {
                tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
            count += 1;
        }
        return m;
    }
}