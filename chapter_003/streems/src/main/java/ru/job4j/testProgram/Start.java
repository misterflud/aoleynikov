package ru.job4j.testProgram;

import ru.job4j.Chat;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Anton on 05.04.2017.
 * 1. Создать программу для поиска файла.
 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
 4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 Ключи
 -d - директория в которая начинать поиск.
 -n - имя файл, маска, либо регулярное выражение.
 -m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение.
 -o - результат записать в файл.
 5. Программа должна записывать результат в файл.
 6. В программе должна быть валидация ключей и подсказка.
 sfsf.txt
 C:\java\for_tests
 -d C:\java\for_tests -n sfsf.txt
 -d C:/java/for_tests -n sfsf.txt -f -o log.txt
 */
public class Start {
    /**
     * directory.
     */
    private String directory;
    /**
     * argumentOfTypeOfFilter.
     */
    private String argumentOfTypeOfFilter;
    /**
     * fileSearched.
     */
    private String fileSearched;
    /**
     * fileWithResult.
     */
    private String fileWithResult;
    /**
     * pathFileWithResult.
     */
    private String pathFileWithResult;

    /**
     * Main.
     * @param args args
     * @throws Exception InvalidKey
     */
    public static void main(String[] args)  throws Exception  {
        Start start = new Start();
        start.printInfo();
        start.parser(args);
        start.manage();

    }

    /**
     * Managing in begin process.
     */
    public void manage() {
        ManagerOfSearch managerOfSearch = new ManagerOfSearch(directory, argumentOfTypeOfFilter, fileSearched); //следует весь массив передать
        ArrayList<String> files = managerOfSearch.start();
        for (String iter : files) {
            System.out.println(iter);
        }
        writeResult(files);
    }

    /**
     * Dividing args and validating key.
     * @param args args
     * @throws Exception InvalidKey
     */
    public void parser(String[] args) throws Exception { //здесь же и проведем валидацию // но потом //и кстати это тоже всякие действия можно использовать стратегию
        if (!("-d".equals(args[0]) & "-n".equals(args[2]) && ("-m".equals(args[4]) || "-f".equals(args[4]) || "-r".equals(args[4])) && "-o".equals(args[5]))) {
            throw new InvalidKey();
        }
        this.directory = args[1];
        this.fileSearched = args[3];
        this.argumentOfTypeOfFilter = args[4];
        this.fileWithResult = args[6];
    }

    /**
     * Writes in txt file.
     * @param files list.
     */
    public void writeResult(ArrayList<String> files) {
        try {
            getProperties();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFileWithResult + fileWithResult))) {
            for (String iter : files) {
                bufferedWriter.write(iter);
            }
        } catch (Exception e) {
            System.out.println("Something wrong");
        }

    }

    /**
     * Gets information from file properties
     * @throws Exception Exception
     */
    public void getProperties() throws Exception {
        final Properties prs = new Properties();
        ClassLoader load = Chat.class.getClassLoader();
        try (InputStream inputStream = load.getResourceAsStream("config.properties")) {
            prs.load(inputStream);
        }
        this.pathFileWithResult = prs.getProperty("resultForSearchProgram");
    }

    /**
     * Prints help information.
     */
    public void printInfo() {
        System.out.println("-d c:/ -n *.txt -m -o log.txt\n" +
                " Ключи\n" +
                " -d - директория в которая начинать поиск.\n" +
                " -n - имя файл, маска, либо регулярное выражение.\n" +
                " -m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение.\n" +
                " -o - результат записать в файл.");
    }
}
