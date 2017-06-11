package ru.job4j;

/**
 * Created by Anton on 10.06.2017.
 */
public abstract class Line implements Comparable<Line> {
    /**
     * Counts of volume.
     */
    int volume = 0;
    /**
     * Price.
     */
    double price = 0;

    /**
     * Constructor.
     * @param volume volume
     * @param price price
     */
    public Line(int volume, double price) {
        this.volume = volume;
        this.price = price;
    }

    /**
     * Print.
     */
    public void printField() {
        System.out.print(String.format(" %s     %s", volume, price));
    }
}
