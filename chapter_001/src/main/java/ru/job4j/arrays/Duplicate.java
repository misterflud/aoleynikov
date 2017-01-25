package ru.job4j.arrays;

import java.util.Arrays;
/**Deleting duplicate from array.
 *@author Anton Oleynikov
 *version 1
 */
public class Duplicate {
    /**
     *@param m array
     *@return result turned array
     */
    public String[] del(String[] m) {
        int count = 0;
        int len = m.length;
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            if (!m[i].equals("-1")) {
                result[count] = m[i];
                count += 1;
            }
            for (int j = i + 1; j < len; j++) {
                if (m[i].equals(m[j]) && !m[j].equals("-1")) {
                    m[j] = "-1";
                }
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }
}