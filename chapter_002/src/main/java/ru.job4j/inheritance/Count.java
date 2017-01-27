package ru.job4j.inheritance;

/**It's counter items, created like singleton pattern.
 *@author Anton Oleynikov
 *@version 1
 */
public class Count {
    private static Count ourInstance = new Count();
    /**
     *@param count count
     */
    private int count = 0;
    /**
     *Get.
     *@return ourInstance
     */
    public static Count getInstance() {
        return ourInstance;
    }
    /**
     *Protected.
     */
    private Count() {
    }
    /**
     *Just.
     *@return count
     */
    public int getCountItem() {
        count++;
        return count;
    }
}
