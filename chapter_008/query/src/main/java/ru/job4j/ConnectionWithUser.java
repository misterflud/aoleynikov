package ru.job4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Anton on 20.06.2017.
 */
public class ConnectionWithUser implements Connect {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    @Override
    public void sendAnswer(String s) {
        System.out.println(s);
    }

    @Override
    public String takeAnswer() {
        try {
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String sendTakeAnswer(String s) {

        return null;
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
