package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Anton on 05.06.2017.
 */
public class BinaryTreeTest {
    /**
     * Test.
     */
    @Test
    public void whenThen() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        System.out.println(binaryTree.add(5));
        System.out.println(binaryTree.add(1));
        System.out.println(binaryTree.add(10));
        System.out.println(binaryTree.add(6));
        System.out.println(binaryTree.add(4));
        System.out.println(binaryTree.add(8));
        System.out.println(binaryTree.add(11));


        System.out.println("---------------------------");
        System.out.println(binaryTree.rootNode.rightNode.value);
        System.out.println(binaryTree.rootNode.leftNode.value);
        System.out.println("---------------------------");
        Iterator<Integer> iterator = binaryTree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
