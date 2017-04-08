package ru.job4j.testProgram;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Anton on 07.04.2017.
 */
public interface Analyse {

    String getName();

    ArrayList<String> execute(File[] files, String fileSearched);

}
