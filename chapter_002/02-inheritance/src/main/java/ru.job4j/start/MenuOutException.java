package ru.job4j.start;

/**MenuOutException.
 *@author Anton Oleynikov
 *@version 1
 */
public class MenuOutException extends Exception {
    /**
     * Constructor.
     * @param message message
     */
    public MenuOutException(String message) {
        System.out.println(message);
    }
}
