package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 07.05.2017.
 */
public class Container<E> implements SimpleContainer<E> {

    private Object[] ob;


    private int index = 0;



    public Container() {
        ob = new Object[10];
    }

    public Container(int size) {
        ob = new Object[size];
    }

    @Override
    public void add(E value) {
        if(this.index == ob.length - 1) {
            createBigger();
            ob[this.index++] = value;
        } else {
            ob[this.index++] = value;
        }
    }

    @Override
    public E get(int index) {
        return (E) ob[index]; //опять
    }

    @Override
    public Iterator iterator() {

        Iterator<E> iterator = new Iterator<E>() {

        private int it = 0;

        @Override
        public boolean hasNext() {
            int it2 = it + 1;
            if(it2 > index) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            return (E) ob[it++];
        }
    };
        return iterator;
    }

    private void createBigger() {
        Object[] ob2 = new Object[ob.length + 10];
        for (int i = 0; i < ob.length; i++) {
            ob2[i] = ob[i];
        }
        ob = ob2;
    }
}
