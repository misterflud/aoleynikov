package ru.job4j;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 17.04.2017.
 */
public class ConvertListTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        ConvertList convertList = new ConvertList();
        final int[][] mass = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 0, 0}};
        final int rows = 4;
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] it1 : mass) {
            for (int it2 : it1) {
                list.add(it2);
            }
        }
        ArrayList<Integer> result1 = (ArrayList) convertList.toList(mass);
        assertThat(result1, is(list));



        list.remove(list.size() - 1); //удаляем 2 последних нуля
        list.remove(list.size() - 1);

        final int[][] result2 = convertList.toArray(list, rows);
        assertThat(result2, is(mass));
    }
}
