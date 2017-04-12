package ru.job4j.products;

import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by Anton on 12.04.2017.
 */
public class Bread extends Food {
    public Bread() {

    }
    public Bread(GregorianCalendar createDate, GregorianCalendar expireDate) {
        super("Хлеб", createDate, expireDate);
    }

    public void setPrice(HashMap<Food, Integer> typeOfFood) { //мы делаем так, чтобы всю работу делать автоматически
        for(HashMap.Entry<Food, Integer> iter : typeOfFood.entrySet()) { // еда сама реализует присвоение
            if(iter.getKey() instanceof Bread) {
                super.price = iter.getValue();
            }
        }
    }
}
