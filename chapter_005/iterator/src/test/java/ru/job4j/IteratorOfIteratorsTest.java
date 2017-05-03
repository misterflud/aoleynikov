package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 02.05.2017.
 */
public class IteratorOfIteratorsTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {

        IteratorOfIterators iteratorOfIterators = new IteratorOfIterators();

        Iterator<Integer> simple1 = new SimpleIterator<>(new Integer[] {0, 1, 2});
        Iterator<Integer> simple2 = new SimpleIterator<>(new Integer[] {3, 4, 5});
        Iterator<Integer> simple3= new SimpleIterator<>(new Integer[] {6, 7, 8});

        Iterator<Iterator<Integer>> simple4 = new SimpleIterator<>(new Iterator[] {simple1, simple2, simple3});

        Iterator it = iteratorOfIterators.convert(simple4);

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
