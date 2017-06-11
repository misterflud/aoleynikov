package ru.job4j;

/**
 * Created by Anton on 10.06.2017.
 */
public class LineBid extends Line {
    /**
     * Constructor.
     * @param volume volume
     * @param price price
     */
    public LineBid(int volume, double price) {
        super(volume, price);
    }
    /**
     * Comparator.
     * @param o o
     * @return 0, -1, 1
     */
    @Override
    public int compareTo(Line o) {
        if (this.price > o.price) {
            return -1;
        } else if (this.price < o.price) {
            return 1;
        }
        return 0;
    }


}
