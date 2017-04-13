package ru.job4j;

import ru.job4j.products.Bread;
import ru.job4j.products.Food;
import ru.job4j.products.Milk;
import ru.job4j.products.Oil;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Anton on 12.04.2017.
 */
public class GenerateFood {
    /**
     * Create Food list.
     * @return different Food
     */
    public ArrayList<Food> generateFood() {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Bread(new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 15))); //месяцы считаются с 0
        foods.add(new Bread(new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 15)));
        foods.add(new Bread(new GregorianCalendar(2017, 2, 12), new GregorianCalendar(2017, 2, 15))); //в мусор
        foods.add(new Milk(new GregorianCalendar(2017, 3, 1), new GregorianCalendar(2017, 3, 13))); //со скидкой
        foods.add(new Milk(new GregorianCalendar(2017, 3, 11), new GregorianCalendar(2017, 3, 13))); //в Warehouse
        foods.add(new Oil(new GregorianCalendar(2017, 2, 12), new GregorianCalendar(2019, 2, 15)));
        return foods;
    }
}
