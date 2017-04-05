package ru.job4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Anton on 01.04.2017.
 * Communicateing with user.
 */
public class Ask {
    /**
     *
     * @param question It is going to ask user.
     * @return user-answer.
     */
    public String ask(String question) {
        System.out.println(question);
        String answer = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            answer = reader.readLine();
        } catch (Exception e) {
            System.out.println("It is should be work");
        }
        return answer;
    }
}
