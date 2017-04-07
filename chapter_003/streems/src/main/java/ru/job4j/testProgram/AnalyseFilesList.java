package ru.job4j.testProgram;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton on 05.04.2017.
 */
public class AnalyseFilesList {

    private HashMap<String, Analyse> filterList = new HashMap<>();

    public AnalyseFilesList() {
        addInFilterList();
    }

    public void addInFilterList() { //каждый класс-действие само заботится о заполнении но так не получится --нужно тогда статичным запуск их делать (тобишь принудительно загрузились в память)
        AnalyseByName analyseByName = new AnalyseByName();
        filterList.put(analyseByName.getName(), analyseByName);
    }

    public ArrayList<String> analise(String argument, File[] files, String fileSearched) {
        return filterList.get(argument).execute(files, fileSearched);
    }

    public class AnalyseByName implements Analyse {


        @Override
        public String getName() { //получаем аргумент -- ключ
            return "-f";
        }

        @Override
        public ArrayList<String> execute(File[] files, String fileSearched) {
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

    public class AnalyseByMask {

    }

    public class AnalyseByRegular {

    }


}
