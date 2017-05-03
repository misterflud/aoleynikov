package ru.job4j.start;

/**Interface for .
 *@author Anton Oleynikov
 *@version 1
 */
public interface Input {
    /**
     * @param question question.
     * @return answer.
     */
    String ask(String question);
    /**
     * @param question question.
     * @param range range.
     * @return int.
     *@throws MenuOutException MenuOutException
     */
    int ask(String question, int[] range) throws MenuOutException;
}