package ru.job4j.start;

/**BaseAction.
 *@author Anton Oleynikov
 *@version 1
 */
public abstract class BaseAction implements UserAction {
    /**
     * Description of action.
     */
    private String name;

    /**
     * Constructor.
     * @param name name
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * @return String.
     */
    public String info() {
       return String.format("%s. %s", key(), name);
    }
}
