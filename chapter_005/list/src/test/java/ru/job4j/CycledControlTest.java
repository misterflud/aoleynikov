package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 15.05.2017.
 */
public class CycledControlTest {
    /**
     * Test.
     */
    @Test
    public void whenThenOne() {
        CycledControl cycledControl = new CycledControl();
        final Node first = new Node(1);
        final Node two = new Node(2);
        final Node third = new Node(3);
        final Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        assertThat(cycledControl.hasCycle(first), is(true));
    }
    /**
     * Test.
     */
    @Test
    public void whenThenTwo() {
        CycledControl cycledControl = new CycledControl();
        final Node first = new Node(2);
        final Node two = new Node(3);
        final Node third = new Node(4);
        final Node four = new Node(5);

        first.next = two;
        two.next = third;
        third.next = four;


        assertThat(cycledControl.hasCycle(first), is(false));
    }
}
