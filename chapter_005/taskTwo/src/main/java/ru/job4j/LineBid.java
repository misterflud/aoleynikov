package ru.job4j;

/**
 * Created by Anton on 10.06.2017.
 */
public class LineBid extends Line {

    public LineBid(int volume, double price) {
        super(volume, price);
    }

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
