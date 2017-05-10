package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 10.05.2017.
 * @param <E> E
 */
public class LinkedSetContainer<E> extends LinkedContainer<E> {
    /**
     * Adds in linked container.
     * @param value are added element
     */
    @Override
    public void add(E value) {
        if(containsDuplicate(value)) {
            super.add(value);
        }
    }

    /**
     * Checks duplicate in mass[].
     * @param value E
     * @return boolean
     */
    private boolean containsDuplicate(E value) {
        Iterator iterator = super.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                return false;
            }
        }
        return true;
    }
}
