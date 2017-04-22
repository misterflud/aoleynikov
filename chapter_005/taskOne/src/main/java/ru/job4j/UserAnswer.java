package ru.job4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Anton on 20.04.2017.
 */
public class UserAnswer implements Input {
    /**
     * Console asker.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public String askAnswer(String s) {
        System.out.println(s);
        String answer = "";
        try {
            answer = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return answer;
    }
}
