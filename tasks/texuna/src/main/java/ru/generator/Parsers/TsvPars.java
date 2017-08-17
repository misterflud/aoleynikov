package ru.generator.Parsers;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Anton on 12.07.2017.
 */
public class TsvPars {
    /**
     * Iterator for gets String[].
     */
    private Iterator<String[]> iterator;

    /**
     * Constructor.
     * @param path path.
     */
    public TsvPars(String path) {
        createTsv(path);

    }

    /**
     * Gets information string are divided by tabulation.
     * @return String[]
     */
    public String[] getDataNext() {
        return iterator.next();
    }

    /**
     * HasNext?.
     * @return true or false
     */
    public boolean hasLine() {
        return iterator.hasNext();
    }

    /**
     * Gets all information from tsv file.
     * @param path path
     */
    private void createTsv(String path) {
        File file = new File(path);
        TsvParserSettings settings = new TsvParserSettings();
        TsvParser parser = new TsvParser(settings);
        try (FileInputStream fileInputStream = new FileInputStream(file); InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-16")) {
            List<String[]> tsvParserResult = parser.parseAll(reader);
            iterator = tsvParserResult.iterator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
