package ru.job4j;

import java.io.Closeable;
import java.util.ArrayList;

/**
 * Created by Anton on 20.06.2017.
 */
public interface Connect extends Closeable {

    /**
     * Sends message.
     * @param s s
     */
    void sendAnswer(String s);

    /**
     * Takes message.
     * @return string
     */
    String takeAnswer();

    /**
     * Sends and takes message.
     * @param s s
     * @return string
     */
    String sendTakeAnswer(String s);
}
