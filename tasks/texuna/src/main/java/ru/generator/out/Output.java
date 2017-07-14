package ru.generator.out;

import java.io.Closeable;

/**
 * Created by Anton on 14.07.2017.
 */
public interface Output extends Closeable {
    void write(String s);
}
