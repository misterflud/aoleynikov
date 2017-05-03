package ru.job4j.models;

/**Task.
 *@author Anton Oleynikov
 *@version 1
 */
public class Task extends Item {
    /**
     * Class constructor.
     *
     * @param name name bug.
     * @param description short description.
     */
    public Task(String name, String description) {
        super(name, description);
    }
}
