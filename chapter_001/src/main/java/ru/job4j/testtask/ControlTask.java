package ru.job4j.testtask;

/**Find substring.
 *@author Anton Oleynikov
 *version 1
 */
public class ControlTask {
    /**
     *@param origin origin
     *@param sub sub
     *@return boolean
     */
    public boolean contains(String origin, String sub) {
        int len1 = origin.length();
        int len2 = sub.length();
        for (int i = 0; len2 + i - 1 < len1; i++) {
            if (origin.substring(i, i + len2).equals(sub)) {
                return true;
            }
        }
        return false;
    }
}