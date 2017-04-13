package ru.job4j.products;

import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by Anton on 12.04.2017.
 * Milk
 */
public class Milk extends Food {
    /**
     * Simple constructor for create PriceList.
     */
    public Milk() {

    }

    /**
     * Constructor.
     * @param createDate when created
     * @param expireDate expire date
     */
    public Milk(GregorianCalendar createDate, GregorianCalendar expireDate) {
        super("Молоко", createDate, expireDate);
    }

    /**
     * Setting price.
     * @param typeOfFood setting price from Price list
     */
    public void setPrice(HashMap<Food, Integer> typeOfFood) { //мы делаем так, чтобы всю работу делать автоматически
        for (HashMap.Entry<Food, Integer> iter : typeOfFood.entrySet()) { // еда сама реализует присвоение
            if (iter.getKey() instanceof Milk) {
                super.price = iter.getValue();
            }
        }
    }
}
