package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 19.04.2017.
 */
public class SortUserTest {
    /**
     * Test.
     */
    @Test
    public void whenAddListThenReturnSortedListInThree() {
        ArrayList<User> list = new ArrayList<>();
        final User user1 = new User("1", 1);
        final User user2 = new User("3", 3);
        final User user3 = new User("2", 2);
        final User user4 = new User("5", 5);
        final User user5 = new User("1", 1);
        final User user6 = new User("6", 6);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        SortUser sortUser = new SortUser();

        TreeSet<User> should = new TreeSet<>();
        should.add(user1);
        should.add(user5);
        should.add(user3);
        should.add(user2);
        should.add(user4);
        should.add(user6);


        TreeSet<User> result = (TreeSet) sortUser.sort(list);
        for(User iter : result) {
            System.out.println(iter.getAge());
        }

        assertThat(result, is(should));
    }
}
