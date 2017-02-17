package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Anton on 17.02.2017.
 */
public class DeleteTest {
    /**
     *
     * @throws Exception Exception
     */
    @Test
    public void whenSetStreamThenDeleteWorld() throws Exception {
        final String s = "one\r\ntwo\nthree\nfour\nfive\nsix\nseven\neight\nnine\nten\n";
        final String[] words = {"two", "four"};
        final String expected = "one\ncensor\nthree\ncensor\nfive\nsix\nseven\neight\nnine\nten\n";
        byte[] bytes1 = s.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes1);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Delete delete = new Delete();
        delete.dropAbuses(inputStream, outputStream, words);
        String result = outputStream.toString();
        inputStream.close();
        outputStream.close();
        assertThat(result, is(expected));
    }
}
