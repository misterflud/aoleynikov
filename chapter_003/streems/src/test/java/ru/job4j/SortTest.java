package ru.job4j;

import org.junit.Test;

import java.io.File;

/**
 * Created by Anton on 25.02.2017.
 * C:/java/for tests/Sour.txt
 * "C:/java/Sort/Source2.txt"
 * "C:/java/Sort/Source1.txt"
 */
public class SortTest {

    /**
     * Просто точка входа.
     * @throws Exception exception.
     */
    @Test
    public void whenThen() throws Exception {
        Sort sort = new Sort();
        File file = new File("C:/java/for tests/Sour.txt");
        sort.sort(file, "C:/java/Sort/Source1.txt", "C:/java/Sort/Source2.txt");
    }
}
