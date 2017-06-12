package ru.job4j;

/**
 * Created by Anton on 10.06.2017.
 */
public class LineAsk extends Line {
    /**
     * Constructor.
     * @param volume volume
     * @param price price
     */
    public LineAsk(int volume, double price) {
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
            return 1;
        } else if (this.price < o.price) {
            return -1;
        }
        return 0;
    }

    /**
     * Takes string.
     * @return string
     */
    @Override
    public String takeString() {
        StringBuilder str1 = new StringBuilder(" " + price);
        str1.setLength(10);
        StringBuilder str2 = new StringBuilder(" " + volume);
        str2.setLength(10);
        return str1.toString() + str2.toString();
    }

}
