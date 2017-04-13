package ru.job4j.products;

import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by Anton on 12.04.2017.
 * Bread
 */
public class Bread extends Food {
    /**
     * Simple constructor for create PriceList.
     */
    public Bread() {

    }

    /**
     * Constructor.
     * @param createDate when created
     * @param expireDate expire date
     */
    public Bread(GregorianCalendar createDate, GregorianCalendar expireDate) {
        super("Хлеб", createDate, expireDate);
    }

    /**
     * Setting price.
     * @param typeOfFood setting price from Price list
     */
    public void setPrice(HashMap<Food, Integer> typeOfFood) { //мы делаем так, чтобы всю работу делать автоматически
        for (HashMap.Entry<Food, Integer> iter : typeOfFood.entrySet()) { // еда сама реализует присвоение
            if (iter.getKey() instanceof Bread) {
                super.price = iter.getValue();
            }
        }
    }
}
