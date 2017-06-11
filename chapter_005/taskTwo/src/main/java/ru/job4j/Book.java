package ru.job4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Anton on 10.06.2017.
 * BID -- sell
 * Ask -- buy
 * 1760855
 */
public class Book {
    /**
     * Save order by order.
     */
    private HashMap<Integer, Action> orderAgregator = new HashMap<>(1800000);
    /**
     * Save order SELL by price.
     */
    private HashMap<Double, Line> lineBidInGlass = new HashMap<>(100);
    /**
     * Save order BUY by price.
     */
    private HashMap<Double, Line> lineAskInGlass = new HashMap<>(100);
    /**
     * For taking order from orderAgregator (when deleting).
     */
    private Action actionTemp;

    /**
     * Adds or Deletes in SELL or BUY.
     * @param action action
     */
    public void bookManage(Action action) {
        if (action.addOrDel) {
            if (action.bOrA) {
                addBid(action);
            } else {
                addAsk(action);
            }
        } else {
            actionTemp = orderAgregator.get(action.orderId);
            action.bOrA = actionTemp.bOrA;
            if (action.bOrA) {
                deleteBid(action);
            } else {
                deleteAsk(action);
            }
        }
    }

    /**
     * Adds BID.
     * @param action action
     */
    public void addBid(Action action) {
        orderAgregator.put(action.orderId, action);
        if (lineBidInGlass.containsKey(action.price)) {
            lineBidInGlass.get(action.price).volume += action.volume;
        } else {
            lineBidInGlass.put(action.price, new LineBid(action.volume, action.price));
        }
    }

    /**
     * Deletes BID
     * @param action action
     */
    public void deleteBid(Action action) {
        lineBidInGlass.get(actionTemp.price).volume -= actionTemp.volume;
        orderAgregator.remove(action.orderId);
    }

    /**
     * Adds ASK.
     * @param action action
     */
    public void addAsk(Action action) {
        orderAgregator.put(action.orderId, action);
        if (lineAskInGlass.containsKey(action.price)) {
            lineAskInGlass.get(action.price).volume += action.volume;
        } else {
            lineAskInGlass.put(action.price, new LineAsk(action.volume, action.price));
        }
    }

    /**
     * Deletes ASK.
     * @param action deleteAction
     */
    public void deleteAsk(Action action) {
        lineAskInGlass.get(actionTemp.price).volume -= actionTemp.volume;
        orderAgregator.remove(action.orderId);
    }

    /**
     * Prints.
     */
    public void print() {
        System.out.println("Size    BID    ASK    Size");
        TreeSet<Line> treeSetBid = new TreeSet<>();
        TreeSet<Line> treeSetAsk = new TreeSet<>();
        lineBidInGlass.forEach((k,v) -> treeSetBid.add(v));
        lineAskInGlass.forEach((k,v) -> treeSetAsk.add(v));

        Iterator<Line> iteratorBid = treeSetBid.iterator();
        Iterator<Line> iteratorAsk = treeSetAsk.iterator();

        while (iteratorBid.hasNext() || iteratorAsk.hasNext()) {
            if (iteratorBid.hasNext()) {
                iteratorBid.next().printField();
            }
            System.out.print("   ");
            if (iteratorAsk.hasNext()) {
                iteratorAsk.next().printField();
            }
            System.out.println("");
        }
    }
}
