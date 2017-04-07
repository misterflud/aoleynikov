package ru.job4j.testProgram;

import java.util.ArrayList;

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
    private String directory;
    private String argumentOfTypeOfFilter;
    private String fileSearched;
    private String fileWithResult;

    public static void main(String[] args) {

        //new Validation();
        Start start = new Start();
        start.parser(args);
        start.manage();

    }


    public void manage() {
        ManagerOfSearch managerOfSearch = new ManagerOfSearch(directory, argumentOfTypeOfFilter, fileSearched); //следует весь массив передать
        ArrayList<String> files = managerOfSearch.start();
        for(String iter : files) {
            System.out.println(iter);
        }
    }
    public void parser(String[] args) { //здесь же и проведем валидацию // но потом //и кстати это тоже всякие действия можно использовать стратегию
        directory = args[1];
        fileSearched = args[3];
        argumentOfTypeOfFilter = args[4];
        fileWithResult = args[5];
    }
}
