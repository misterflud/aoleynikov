package ru.job4j;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton on 28.05.2017.
 */
public class ReferenceTests {
    @Test
    public void whenThen() {
        Reference<EasyHash, Integer> map = new Reference<EasyHash, Integer>();

        EasyHash hash1 = new EasyHash( 1);
        EasyHash hash2 = new EasyHash( 2);
        EasyHash hash3 = new EasyHash( 3);
        map.insert(hash1, 1);
        map.insert(hash2, 2);
        map.insert(hash3, 3);

        System.out.println(map.get(hash1));
    }

}
