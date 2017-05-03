package ru.job4j;


/**
 * Created by Anton on 03.05.2017.
 * @param <E> what you want
 */
public class SimpleArray<E> {
    /**
     * Massive.
     */
    private Object[] mass;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param size size
     */
    public SimpleArray(int size) {
        this.mass = new Object[size];
    }

    /**
     * Adds elements.
     * @param value value
     */
    public void add(E value) {
        mass[index++] = value;
    }

    /**
     * Deletes elements.
     * @param index index
     */
    public void delete(int index) {
        mass[index] = null;
    }

    /**
     * Update massive.
     */
    public void update() {
        Object[] mass2 = new Object[mass.length];
        int j = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == null) {
                continue;
            }
            mass2[j++] = mass[i];
        }
        mass = mass2;
    }

    /**
     * Gets element from massive.
     * @param index index
     * @return object of E
     */
    public E get(int index) {
        return (E) mass[index];
    }


}
