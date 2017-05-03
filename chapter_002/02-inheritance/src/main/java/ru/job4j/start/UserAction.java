package ru.job4j.start;

/**UserAction
 * .
 *@author Anton Oleynikov
 *@version 1
 */
public interface UserAction {
    /**
     * @return int.
     */
    int key();

    /**
     * @param input input.
     * @param tracker tracker.
     */
    void execute(Input input, Tracker tracker);
    /**
     * @return String.
     */
    String info();
}
