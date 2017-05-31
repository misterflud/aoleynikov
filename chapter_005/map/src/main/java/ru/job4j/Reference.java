package ru.job4j;

import java.util.Iterator;

/**
 * Created by Anton on 30.05.2017.
 * @param <K> key
 * @param <V> value
 */
public class Reference<K, V> implements MyMap<K, V>, Iterable<V> {

    //private Position[] mass = new Position[100]; // generic array creation что это?? не ясно. Еще есть проблема -- данный массив всегда увеличивается..

    /**
     * Container of hashSum.
     */
    private Node[][] massIter = new Node[100][100];
    /**
     * Last added Node.
     */
    private Node lastNode;
    /**
     * Counts adds.
     */
    private int index = 0;
    /**
     * Adds elements.
     * @param key key
     * @param value value
     * @return boolean
     */
    @Override
    public boolean insert(K key, V value) {
        Position position = getPosition(key);
        int firstPosition = position.firstPosition;
        int lastPosition = position.lastPosition;
        if (checkDuplicate(firstPosition, lastPosition)) {
            Node newNode = new Node(key, value);
            //если первое добавление
            if (lastNode != null) {
                lastNode.nextNode = newNode;
                newNode.previousNode = lastNode;
            }
            massIter[firstPosition][lastPosition] = newNode;
            lastNode = newNode;
            index++;
        } else {
            return false;
        }
        return true;
    }

    /**
     * Gets elements.
     * @param key key
     * @return generic V
     */
    @Override
    public V get(K key) {
        Position position = getPosition(key);
        return (V) massIter[position.firstPosition][position.lastPosition].value;
    }
    /**
     * Deletes elements.
     * @param key key
     * @return boolean
     */
    @Override
    public boolean delete(K key) {
        Position position = getPosition(key);
        if (massIter[position.firstPosition][position.lastPosition].equals(lastNode)) {
            lastNode = lastNode.previousNode;
        }
        if (massIter[position.firstPosition][position.lastPosition].nextNode != null) {
            massIter[position.firstPosition][position.lastPosition].nextNode.previousNode = massIter[position.firstPosition][position.lastPosition].previousNode;
        }
        if (massIter[position.firstPosition][position.lastPosition].previousNode != null) {
            massIter[position.firstPosition][position.lastPosition].previousNode.nextNode = massIter[position.firstPosition][position.lastPosition].nextNode;
        }

        massIter[position.firstPosition][position.lastPosition] = null;
        index--;
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
     * Getter Iterator.
     * @return Iterator
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private Node node = lastNode;

            private int index2 = index;

            @Override
            public boolean hasNext() {
                if (index2 != 0) {
                    return true;
                }
                return false;
            }

            @Override
            public V next() {
                V value = (V) node.value;
                index2--;
                node = node.previousNode;
                return value;
            }
        };
    }

    /**
     * Node.
     * @param <K> key
     * @param <V> value
     */
    private class Node<K, V> {
        /**
         * Key.
         */
        K key;
        /**
         * Value.
         */
        V value;
        /**
         * Next Node.
         */
        Node nextNode;
        /**
         * Previous Node.
         */
        Node previousNode;

        /**
         * Constructor.
         * @param key key
         * @param value value
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Equals.
         * @param o o
         * @return boolean
         */
        @Override
        public boolean equals(Object o) {
            if (o instanceof Node) {
                Node node2 = (Node) o;
                if (this.key.equals(node2.key) && this.value.equals(node2.value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Position in table.
     * @param <D> null
     */
    private class Position<D> { //приходится использовать какие то дженерики чтобы избежать generic array creation
        /**
         * Position.
         */
        int firstPosition;
        /**
         * Position.
         */
        int lastPosition;

        /**
         * Constructor.
         * @param firstPosition firstPosition
         * @param lastPosition lastPosition
         */
        public Position(int firstPosition, int lastPosition) {
            this.firstPosition = firstPosition;
            this.lastPosition = lastPosition;
        }
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
