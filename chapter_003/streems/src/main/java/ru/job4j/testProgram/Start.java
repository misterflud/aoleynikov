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
 */
public class Start {
    public static void main(String[] args) {

        //new Validation();
        ManagerOfSearch managerOfSearch = new ManagerOfSearch(args); //следует весь массив передать
        ArrayList<String> files = managerOfSearch.start();
        for(String iter : files) {
            System.out.println(iter);
        }
    }
}
