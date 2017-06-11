package ru.job4j;

/**
 * Created by Anton on 11.06.2017.
 */
public class Action {
    /**
     * Order.
     */
    int orderId;
    /**
     * Which book.
     */
    String book;
    /**
     * True -- Add, False -- Del.
     */
    boolean addOrDel;
    /**
     * True -- BID false -- ASK.
     */
    boolean bOrA;
    /**
     * Price.
     */
    double price;
    /**
     * Volume.
     */
    int volume;

    /**
     * For Adding.
     * @param book book
     * @param operation operation
     * @param price price
     * @param volume volume
     * @param orderId orderId
     */
    public Action(String book, String operation, String price, String volume, String orderId) {
        this.book = book;

        if (operation.equals("BUY")) {
            this.bOrA = true;
        } else {
            this.bOrA = false;
        }

        this.price = Double.parseDouble(price);

        this.volume = Integer.parseInt(volume);

        this.orderId = Integer.parseInt(orderId);


        this.addOrDel = true;
    }

    /**
     * For deleting
     * @param orderId orderId
     * @param book book
     */
    public Action(String book, String orderId) {
        this.book = book;

        this.orderId = Integer.parseInt(orderId);

        this.addOrDel = false;
    }

}
