package ru.job4j;

import java.io.InputStream;

/**
 * Created by Anton on 16.02.2017.
 */
public class Number {
    /**
    public static void main(String[] args) throws Exception{
        ByteArrayInputStream bytes = new ByteArrayInputStream(new byte[]{2});
        Number nb = new Number();
        nb.isNumber(bytes);
    }
    */

    /**
     *
     * @param in InputStream
     * @return true or false
     * @throws Exception Exception
     */
    public boolean isNumber(InputStream in) throws Exception {
        if (in.read() % 2 == 0) {
            return true;
        }
        return false;
    }
}
