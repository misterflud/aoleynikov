package ru.job4j;

/**
 * Created by Anton on 15.05.2017.
 */
public class CycledControl {
    /**
     * Container.
     */
    private Container<Integer> containerHash = new Container();

    /**
     * Checks cycles.
     * @param first first
     * @return true or false
     */
    public boolean hasCycle(Node first) {
        Node node = first;
        containerHash.add(node.hashCode());
        while (node.next != null) {
            node = node.next;
            if (contained(node.hashCode())) {
                return true;
            }
            containerHash.add(node.hashCode());
        }
        return false;
    }

    /**
     * Checks hashcode.
     * @param hash hashcode
     * @return true or false
     */
    private boolean contained(int hash) {
        for (int it : containerHash) {
            if (it == hash) {
                return true;
            }
        }
        return false;
    }
}
