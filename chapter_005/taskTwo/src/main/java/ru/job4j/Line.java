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

    /**
     * Takes string.
     * @return string
     */
    public String takeString() {
        StringBuilder str1 = new StringBuilder(" " + volume);
        str1.setLength(10);
        StringBuilder str2 = new StringBuilder(" " + price);
        str2.setLength(10);
        return str1.toString() + str2.toString();
    }
}
