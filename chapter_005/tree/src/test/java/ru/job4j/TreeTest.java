package ru.job4j;

import org.junit.Test;
import java.util.Iterator;

/**
 * Created by Anton on 02.06.2017.
 */
public class TreeTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        Tree<Integer> tree = new Tree<>();

        System.out.println(tree.add(1, 1));

        System.out.println(tree.add(1, 2));
        System.out.println(tree.add(1, 3));
        System.out.println(tree.add(1, 4));
        System.out.println(tree.add(1, 5));
        System.out.println(tree.add(4, 6));
        System.out.println(tree.add(4, 7));
        System.out.println(tree.add(3, 8));
        System.out.println(tree.add(8, 9));

        System.out.println(tree.add(31, 12));


        System.out.println("*********************************");

        Iterator<Integer> iterator = tree.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("*********************************");

        System.out.println(tree.isBinary());
    }
}
