package ru.job4j.testProgram;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Anton on 05.04.2017.
 * C:\java\for_tests
 */
public class ManagerOfSearch {
    /**
     *
     */
    private ArrayList<String> filesFound = new ArrayList<>();
    /**
     * where we are searching.
     */
    private String pathStart;
    /**
     * Which key-filter we are using.
     */
    private String argumentOfTypeOfFilter;
    /**
     *
     */
    private AnalyseFilesList analyseFilesList;
    /**
     * What we are searching.
     */
    private String fileSearched;

    /**
     *
     * @param directory where we are searching
     * @param argumentOfTypeOfFilter which key-filter we are using
     * @param fileSearched what we are searching
     */
    public ManagerOfSearch(String directory, String argumentOfTypeOfFilter, String fileSearched){ //мы не должны разбивать массив здесь, ибо если придет другой массив -- ничего не будет работать. пусть делает start
        this.pathStart = directory;
        this.argumentOfTypeOfFilter = argumentOfTypeOfFilter;
        this.fileSearched = fileSearched;

        analyseFilesList = new AnalyseFilesList();
    }

    /**
     *
     * @return result searching
     */
    public ArrayList<String> start() {
        startSearch(pathStart);
        return filesFound;
    }

    /**
     * Start recursion searching.
     * @param path start directory.
     */
    public void startSearch(String path) { //рекурсивный поиск
        File[] files = new File(path).listFiles();
        ArrayList<File> folders = getFolders(files);

        getResult(analyseFilesList.analise(argumentOfTypeOfFilter, files, fileSearched));

        if (folders.size() > 0) {
            for (File iter : folders) { //либо file
                startSearch(iter.getAbsolutePath());
            }
        }
    }

    /**
     * Get all folder in directory, after that we are creating recursion in startSearch().
     * @param files all files in directory
     * @return
     */
    public ArrayList<File> getFolders(File[] files) { //получаем список папок
        ArrayList<File> folders = new ArrayList<>();
        for (File iter : files) {
            if (!iter.getAbsolutePath().contains(".")) {
                folders.add(iter);
            }
        }
        return folders;
    }

    /**
     * Add founded files after each recursion.
     * @param filesFound what we found.
     */
    public void getResult(ArrayList<String> filesFound) { //добавляем найденные файлы в результат
        if(filesFound.size() > 0) {
            this.filesFound.addAll(filesFound);
        }
    }
}
