package ru.job4j.start;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**ConsoleInput prints questions from StartUI and takes information from console.
 *@author Anton Oleynikov
 *@version 1
 */
public class ConsoleInput implements Input {
    /**
     * Reader from Console.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @param question question.
     * @return String
     */
    public String ask(String question) {
        System.out.println(question);
        String s = new String();
        try {
            s = reader.readLine();
        } catch (Exception e) {

        }
        return s;
    }

    /**
     *
     * @param question question.
     * @param range range.
     * @return int
     * @throws MenuOutException MenuOutException
     */
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of choose range.");
        }
    }
}
