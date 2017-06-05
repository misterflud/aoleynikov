package ru.job4j;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Anton on 05.06.2017.
 */
public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {
    /**
     * Root Node.
     */
    Node<E> rootNode;
    /**
     * Index.
     */
    private int index = 0;
    /**
     * Save temporary Node.
     */
    private ArrayList<Node<E>> iteratorArray;
    /**
     * Flag.
     */
    private boolean flagAdd;

    /**
     * Iterator.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        iteratorArray = new ArrayList<>();
        bypassTree(rootNode);
        Iterator<Node<E>> iterator = iteratorArray.iterator();

        return new Iterator<E>() {
            /**
             * Has next?.
             * @return E
             */
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            /**
             * Next.
             * @return E
             */
            @Override
            public E next() {
                return iterator.next().value;
            }
        };
    }

    /**
     * Node.
     * @param <E> e
     */
    class Node<E> {

        Node<E> leftNode;

        Node<E> rightNode;
        /**
         * value.
         */
        E value;

        /**
         * Constructor.
         * @param e value
         */
        private Node(E e) {
            this.value = e;
        }
    }

    /**
     *
     * @param child child
     * @return boolean
     */
    public boolean add(E child) {
        if (rootNode == null) {
            rootNode = new Node<>(child);
            index++;
            return true;
        } else {
            findPlace(child, rootNode);
            if (flagAdd) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param child child
     * @param startNode startNode
     */
    private void findPlace(E child, Node<E> startNode) {
        if (child.compareTo(rootNode.value) > 0) {
            if (startNode.rightNode == null) {
                startNode.rightNode = new Node<>(child);
                flagAdd = true;
            } else {
                findPlace(child, startNode.rightNode);
            }
        } else if (child.compareTo(rootNode.value) < 0){
            if (startNode.leftNode == null) {
                startNode.leftNode = new Node<>(child);
                flagAdd = true;
            } else {
                findPlace(child, startNode.leftNode);
            }
        }
    }

    /**
     * For iteratorArray.
     * @param startNode startNode
     */
    private void bypassTree(Node<E> startNode) {
        if (startNode != null) {
            iteratorArray.add(startNode);
            if (startNode.leftNode != null) {
                bypassTree(startNode.leftNode);
            }
            if (startNode.rightNode != null) {
                bypassTree(startNode.rightNode);
            }
        }
    }
}
