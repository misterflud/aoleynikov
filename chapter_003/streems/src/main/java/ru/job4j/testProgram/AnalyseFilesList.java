package ru.job4j.testProgram;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Anton on 05.04.2017.
 */
public class AnalyseFilesList {

    private String fileSearched;

    public AnalyseFilesList(String fileSearched) {
        this.fileSearched = fileSearched;
    }

    public ArrayList<String> execute(File[] files) {
        ArrayList<String> filesFound = new ArrayList<>();

        for (File iter : files) {
            if (iter.getName().equals(fileSearched)) {
                filesFound.add(iter.getAbsolutePath());
                System.out.println(iter.getAbsolutePath());
            }
        }
        return filesFound;
    }


}
