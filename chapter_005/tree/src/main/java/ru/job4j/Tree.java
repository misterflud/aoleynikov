package ru.job4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anton on 01.06.2017.
 * @param <E> e
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Root Node.
     */
    private Node<E> rootNode;
    /**
     * Index.
     */
    private int index = 0;
    /**
     * Save temporary Node.
     */
    private Node<E> tempNode;
    /**
     * For iteration.
     */
    private ArrayList<Node<E>> iteratorArray;

    /**
     * Node.
     * @param <E> e
     */
    class Node<E> {
        /**
         * ChildrenList.
         */
        List<Node<E>> children = new LinkedList<>();
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
     * Add child to parent.
     * @param parent parent.
     * @param child child.
     * @return boolean
     */
    @Override
    public boolean add(E parent, E child) {
        if (rootNode == null) {
            rootNode = new Node<>(child);
            index++;
            return true;
        } else {
            findParent(parent, rootNode);
            if (tempNode != null) {
                tempNode.children.add(new Node<E>(child));
                index++;
                tempNode = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Iterator.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        iteratorArray = new ArrayList<Node<E>>();
        iteratorArray.add(rootNode);
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
            public E next() { // придется вначале дерево преобазовывать в обычный список.
                return iterator.next().value;
            }
        };
    }

    /**
     * Finds parent Node.
     * @param parent parent Node
     * @param startNode start for finding Node
     */
    private void findParent(E parent, Node<E> startNode) { //мерзкая рекурсия работает криво -- даже если находит элемент в итоге возвращает что не находит...Пришлось отказаться от return
        for (Node<E> e : startNode.children) {
            if (e.value.compareTo(parent) == 0) {
                tempNode = e;
            }
            if (e.children.size() > 0) {
                findParent(parent, e);
            }
        }
        if (rootNode.value.compareTo(parent) == 0) {
            tempNode = rootNode;
        }
    }

    /**
     * For iteratorArray.
     * @param startNode startNode
     */
    private void bypassTree(Node<E> startNode) {
        for (Node<E> e : startNode.children) {
            iteratorArray.add(e);
            if (e.children.size() > 0) {
                bypassTree(e);
            }
        }
    }
}
