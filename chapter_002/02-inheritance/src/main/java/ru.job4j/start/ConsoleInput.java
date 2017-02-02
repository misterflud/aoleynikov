package ru.job4j.start;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**ConsoleInput prints questions from StartUI and takes information from console.
 *@author Anton Oleynikov
 *@version 1
 */
public class ConsoleInput implements Input {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public String ask(String question) {
        System.out.println(question);
        String s = new String();
        try {
            s = reader.readLine();
        } catch (Exception e){

        }
        return s;
    }
}
