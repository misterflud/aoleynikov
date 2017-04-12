package ru.job4j.products;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by Anton on 12.04.2017.
 */
public abstract class Food {
    protected String name;

    protected GregorianCalendar expireDate;

    protected GregorianCalendar createDate;

    protected int price;

    private int discount; // в %

    private long fresh;

    //protected long fresh;

    public Food(String name, GregorianCalendar createDate, GregorianCalendar expireDate) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        setFresh();
        discount = 0;
        price = -1;
    }

    public Food() {

    }

    private void setFresh() {
        GregorianCalendar now = new GregorianCalendar();
        long a = (now.getTimeInMillis() - this.createDate.getTimeInMillis());
        long b = (this.expireDate.getTimeInMillis() - this.createDate.getTimeInMillis());
        fresh = a / b;
        //fresh = (new GregorianCalendar().getTimeInMillis() - this.createDate.getTimeInMillis()) / (this.expireDate.getTimeInMillis() - this.createDate.getTimeInMillis());

    }

    public long getFresh() {
        return fresh;
    }

    public abstract void setPrice(HashMap<Food, Integer> typeOfFood);

    public int getPrice() {
        return this.price * (1 - discount / 100);
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getInformation() {
        if (price == -1) {
            return String.format("Название: %s Дата изготовление: %s Употребить до: %s Скидка в процентах: %s", name, createDate.getTime(), expireDate.getTime(), discount); //мб удалить сторку
        } else {
            return String.format("Название: %s Дата изготовление: %s Употребить до: %s Цена %s Скидка в процентах: %s Несвежесть: %s", name, createDate.getTime(), expireDate.getTime(), price, discount, fresh);
        }
    }

}
