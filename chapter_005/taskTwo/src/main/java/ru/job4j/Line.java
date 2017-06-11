package ru.job4j;

/**
 * Created by Anton on 10.06.2017.
 */
public abstract class Line implements Comparable<Line> {

    int volume = 0;

    double price = 0;

    public Line(int volume, double price) {
        this.volume = volume;
        this.price = price;
    }

    public void printField() {
        System.out.print(String.format(" %s     %s", volume, price));
    }
}
