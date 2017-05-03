package ru.job4j.start;

/**MenuOutException.
 *@author Anton Oleynikov
 *@version 1
 */
public class MenuOutException extends RuntimeException { //данное наследование позволяет не обрабатывать исключения (точнее это становится необязательным)
    /**
     * Constructor.
     * @param message message
     */
    public MenuOutException(String message) {
        super(message);
    }
}
