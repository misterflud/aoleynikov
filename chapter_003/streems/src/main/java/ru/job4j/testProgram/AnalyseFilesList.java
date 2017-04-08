package ru.job4j.testProgram;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anton on 05.04.2017.
 */
public class AnalyseFilesList {
    /**
     * file's list are founded
     */
    private HashMap<String, Analyse> filterList = new HashMap<>();

    /**
     * Constructor with initial of action.
     */
    public AnalyseFilesList() {
        addInFilterList();
    }

    /**
     * Adds all action.
     */
    public void addInFilterList() { //каждый класс-действие само заботится о заполнении но так не получится --нужно тогда статичным запуск их делать (тобишь принудительно загрузились в память)
        AnalyseByName analyseByName = new AnalyseByName();
        AnalyseByMask analyseByMask = new AnalyseByMask();
        AnalyseByRegular analyseByRegular = new AnalyseByRegular();

        filterList.put(analyseByName.getName(), analyseByName);
        filterList.put(analyseByMask.getName(), analyseByMask);
        filterList.put(analyseByRegular.getName(), analyseByRegular);
    }

    /**
     *
     * @param argument which key-filter we are using
     * @param files where we are searching
     * @param fileSearched what we are searching
     * @return list of absolute path to files which are founded
     */
    public ArrayList<String> analise(String argument, File[] files, String fileSearched) {
        return filterList.get(argument).execute(files, fileSearched);
    }

    /**
     * Filter.
     */
    public class AnalyseByName implements Analyse {

        /**
         *
         * @return argument
         */
        @Override
        public String getName() { //получаем аргумент -- ключ
            return "-f";
        }

        /**
         *
         * @param files file's list
         * @param fileSearched user's regular expression
         * @return file's list are founded
         */
        @Override
        public ArrayList<String> execute(File[] files, String fileSearched) {
            ArrayList<String> filesFound = new ArrayList<>();
            for (File iter : files) {
                if (iter.getName().equals(fileSearched)) {
                    filesFound.add(iter.getAbsolutePath());
                    //System.out.println(iter.getAbsolutePath());
                }
            }
            return filesFound;
        }
    }

    /**
     * Filter.
     */
    public class AnalyseByMask implements Analyse {

        /**
         *
         * @return argument
         */
        @Override
        public String getName() {
            return "-m";
        }

        /**
         *
         * @param files file's list
         * @param fileSearched user's regular expression
         * @return file's list are founded
         */
        @Override
        public ArrayList<String> execute(File[] files, String fileSearched) {
            ArrayList<String> filesFound = new ArrayList<>();
            String[] symbols = {"\\", "#", "|", "(", ")", "[", "]", "{", "}", "^", "$", "+", "."}; //символы которые нужно экранировать
            String reg1 = "";
            String reg2;
            for (String iter : symbols) { //проэкранировали
                reg1 = fileSearched.replace(iter, "\\" + iter);
            }
            reg2 = reg1.replace("?", "."); //меняем маску на регулярные выражения
            reg2 = reg1.replace("*", ".*");
            for (File iter : files) {
                if (iter.getName().matches(reg2)) {
                    filesFound.add(iter.getAbsolutePath());
                }
            }
            return filesFound;
        }
    }

    /**
     * Filter.
     */
    public class AnalyseByRegular implements Analyse { //не совсем ясно что имелось ввиду, но допустим пользователь знает что мы используем java и он понимает как строить регулярные выражения
        /**
         *
         * @return argument
         */
        @Override
        public String getName() {
            return "-r";
        }

        /**
         *
         * @param files file's list
         * @param fileSearched user's regular expression
         * @return file's list are founded
         */
        @Override
        public ArrayList<String> execute(File[] files, String fileSearched) {
            ArrayList<String> filesFound = new ArrayList<>();
            for (File iter : files) {
                if (iter.getName().matches(fileSearched)) {
                    filesFound.add(iter.getAbsolutePath());
                }
            }
            return filesFound;
        }
    }
}
