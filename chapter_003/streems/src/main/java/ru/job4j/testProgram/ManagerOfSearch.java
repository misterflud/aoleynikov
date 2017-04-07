package ru.job4j.testProgram;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Anton on 05.04.2017.
 * C:\java\for_tests
 */
public class ManagerOfSearch {

    private ArrayList<String> filesFound = new ArrayList<>();
    private String pathStart;
    private String argumentOfTypeOfFilter;
    private AnalyseFilesList analyseFilesList;
    private String fileSearched;

    public ManagerOfSearch(String directory, String argumentOfTypeOfFilter, String fileSearched){ //мы не должны разбивать массив здесь, ибо если придет другой массив -- ничего не будет работать. пусть делает start

        this.pathStart = directory;
        this.argumentOfTypeOfFilter = argumentOfTypeOfFilter;
        this.fileSearched = fileSearched;

        analyseFilesList = new AnalyseFilesList();
    }


    public ArrayList<String> start() {


        startSearch(pathStart);
        //analyseFilesList = new AnalyseFilesList(fileSearched); //если оставить это сдесь -- вылазиет ошибка Exception in thread "main" java.lang.NullPointerException почему так?
        return filesFound;
    }


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

    public ArrayList<File> getFolders(File[] files) { //получаем список папок
        ArrayList<File> folders = new ArrayList<>();
        for (File iter : files) {
            if (!iter.getAbsolutePath().contains(".")) {
                folders.add(iter);
            }
        }
        return folders;
    }

    public void getResult(ArrayList<String> filesFound) { //добавляем найденные файлы в результат
        if(filesFound.size() > 0) {
            filesFound.addAll(filesFound);
        }
    }
}
