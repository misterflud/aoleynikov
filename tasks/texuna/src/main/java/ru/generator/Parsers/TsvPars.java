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

    private Iterator<String[]> iterator;

    public TsvPars(String path) {
        createTsv(path);

    }

    public String[] getDataNext() {
        return iterator.next();
    }

    public boolean hasLine() {
        return iterator.hasNext();
    }

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
