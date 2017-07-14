package ru.generator.out;

import ru.generator.out.Output;

import java.io.*;

/**
 * Created by Anton on 14.07.2017.
 */
public class WriteInFile implements Output, Closeable {

    private FileOutputStream fileOutputStream;

    private OutputStreamWriter outputStreamWriter;

    public WriteInFile(String path) {
        try {
            File file = new File(path);
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void write(String s) {
        try {
            outputStreamWriter.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() throws IOException {
        outputStreamWriter.close();
        fileOutputStream.close();
    }
}
