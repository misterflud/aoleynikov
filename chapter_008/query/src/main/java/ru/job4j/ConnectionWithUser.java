package ru.job4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Anton on 20.06.2017.
 */
public class ConnectionWithUser implements Connect {

    /**
     * Stream.
     */
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Sends message.
     * @param s s
     */
    @Override
    public void sendAnswer(String s) {
        System.out.println(s);
    }

    /**
     * Takes message.
     * @return string
     */
    @Override
    public String takeAnswer() {
        try {
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Sends and takes message.
     * @param s s
     * @return string
     */
    @Override
    public String sendTakeAnswer(String s) {
        try {
            System.out.println(s);
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Closes streams.
     * @throws IOException IOException
     */
    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
