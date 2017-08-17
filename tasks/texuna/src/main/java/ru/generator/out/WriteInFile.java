package ru.generator.out;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * Created by Anton on 14.07.2017.
 *
 */
public class WriteInFile implements Output, Closeable {
    /**
     * FileStream.
     */
    private FileOutputStream fileOutputStream;
    /**
     * OutPutStream.
     */
    private OutputStreamWriter outputStreamWriter;

    /**
     * Constructor.
     * @param path path of file
     */
    public WriteInFile(String path) {
        try {
            File file = new File(path);
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Writes in stream.
     * @param s String
     */
    @Override
    public void write(String s) {
        try {
            outputStreamWriter.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Closes.
     * @throws IOException Exception
     */
    @Override
    public void close() throws IOException {
        outputStreamWriter.close();
        fileOutputStream.close();
    }
}
