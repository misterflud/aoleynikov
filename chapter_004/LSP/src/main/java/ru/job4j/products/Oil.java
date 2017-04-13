package ru.job4j.products;

import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by Anton on 12.04.2017.
 * Oil
 */
public class Oil extends Food {

    /**
     * Simple constructor for create PriceList.
     */
    public Oil() {

    }

    /**
     * Constructor.
     * @param createDate when created
     * @param expireDate expire date
     */
    public Oil(GregorianCalendar createDate, GregorianCalendar expireDate) {
        super("Подсолнечное масло", createDate, expireDate);
    }

    /**
     * Setting price.
     * @param typeOfFood setting price from Price list
     */
    public void setPrice(HashMap<Food, Integer> typeOfFood) { //мы делаем так, чтобы всю работу делать автоматически
        for (HashMap.Entry<Food, Integer> iter : typeOfFood.entrySet()) { // еда сама реализует присвоение
            if (iter.getKey() instanceof Oil) {
                super.price = iter.getValue();
            }
        }
    }
}
