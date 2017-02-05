package ru.job4j.max;

/**Max between 3 or 2 numbers.
 *@author Anton Oleynikov
 *@version 1
 */
public class Max {
    /**
     *@param first first
     *@param second second
     *@return int
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
    /**
     *@param first first
     *@param second second
     *@param third third
     *@return int
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}