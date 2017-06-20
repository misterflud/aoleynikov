package ru.job4j;

import java.io.Closeable;
import java.util.ArrayList;

/**
 * Created by Anton on 20.06.2017.
 */
public interface Connect extends Closeable {

    void sendAnswer(String s);

    String takeAnswer();

    String sendTakeAnswer(String s);
}
