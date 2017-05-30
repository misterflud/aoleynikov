package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 30.05.2017.
 */
public class Reference<K, V> implements MyMap <K, V>, Iterable<K> {

    private Position[] mass = new Position[100]; // generic array creation что это?? не ясно. Еще есть проблема -- данный массив всегда увеличивается..

    /**
     * Container of hashSum.
     */
    private Node[][] massIter = new Node[100][100];
    /**
     * Index.
     */
    private int index = 0;

    @Override
    public boolean insert(K key, V value) {
        Position position = getPosition(key);
        int firstPosition = position.firstPosition;
        int lastPosition = position.lastPosition;
        if (index == mass.length - 1) {
            massBigger();
        }
        if (checkDuplicate(firstPosition, lastPosition)) {
            mass[index++] = new Position(firstPosition, lastPosition);
            massIter[firstPosition][lastPosition] = new Node(key, value, index);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public V get(K key) {
        Position position = getPosition(key);
        return (V) massIter[position.firstPosition][position.lastPosition].value ;
    }

    @Override
    public boolean delete(K key) {
        Position position = getPosition(key);
        int indexRemoved = massIter[position.firstPosition][position.lastPosition].positionInMas;
        massIter[position.firstPosition][position.lastPosition] = null;
        mass[indexRemoved] = null;
        return true;
    }

    /**
     * Getter.
     * @param key key
     * @return object of Position
     */
    private Position getPosition(K key) {
        int hash = key.hashCode();
        double hashDouble = key.hashCode();
        int firstPosition = hash / 100;
        int lastPosition = (int) ((hashDouble / 100 - firstPosition) * 100);
        return new Position(firstPosition, lastPosition);
    }

    /**
     * Getter.
     * @return Iterator
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public K next() {
                return null;
            }
        };
    }

    /**
     * Node.
     * @param <K> key
     * @param <V> value
     */
    private class Node<K, V> {
        K key;
        V value;
        int positionInMas;

        public Node(K key, V value, int positionInMass) {
            this.key = key;
            this.value = value;
            this.positionInMas = positionInMass;
        }

        @Override
        public boolean equals(Object o) {
            Node node2 = (Node) o;
            if (this.key.equals(node2.key) && this.value.equals(node2.value)) {
                return true;
            }
            return false;
        }
    }

    /**
     * Position in table.
     * @param <D> null
     */
    private class Position<D> { //приходится использовать какие то дженерики чтобы избежать generic array creation
        int firstPosition;

        int lastPosition;

        public Position(int firstPosition, int lastPosition) {
            this.firstPosition = firstPosition;
            this.lastPosition = lastPosition;
        }
    }

    /**
     * Creates mass bigger.
     */
    private void massBigger() {
        Position[] mass2 = new Position[mass.length * 2];
        for (int i = 0; i < mass.length; i++) {
            mass2[i] = mass[i];
        }
        mass = mass2;
    }



    /**
     *
     * Checks duplicate in mass[]. If we have than returned false, don't have than returned true.
     * @param firstPosition [firstPosition][lastPosition]
     * @param lastPosition [firstPosition][lastPosition]
     * @return boolean
     */
    private boolean checkDuplicate(int firstPosition, int lastPosition) {
        if (firstPosition > massIter.length) {
            massIterBigger(firstPosition);
        }
        if (massIter[firstPosition][lastPosition] != null) { //поменять местами true false
            return false;
        }
        return true;
    }

    /**
     * Creates massIter bigger.
     * @param firstPosition [firstPosition][lastPosition]
     */
    private void massIterBigger(int firstPosition) {
        Node[][] massIter2 = new Node[firstPosition][100];
        for (int i = 0; i < massIter.length; i++) {
            for (int j = 0; j < 100; j++) {
                massIter2[i][j] = massIter[i][j];
            }
        }
        massIter = massIter2;
    }
}
