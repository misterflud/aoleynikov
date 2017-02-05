package ru.job4j.loops;

/**Counting even numbers.
 *@author Anton Oleynikov
 *version 1
 */
public class Counter {
    /**
     *@param start start
     *@param finish finish
     *@return count
     */
    public int add(int start, int finish) {
        int count = 0;
        for (int i = start; i < finish; i++) {
            if (i % 2 == 0) {
                count += i;
            }
        }
        return count;
    }
}