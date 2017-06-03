package ru.job4j;

import org.junit.Test;

/**
 * Created by Anton on 06.05.2017.
 */
public class StoresTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        UserStore userStore = new UserStore(5);
        userStore.add(new User()); // тут тоже самое -- ведь в классах я явно указываю что за параметр T и он base, почему unchecked assignment??
        userStore.add(new User());
        userStore.add(new User());
        userStore.add(new User());
        User user = new User();
        String id = user.getId();
        userStore.add(user);

        userStore.printAll();

        userStore.delete(id);
        System.out.println("________________________");
        userStore.printAll();
    }
}
