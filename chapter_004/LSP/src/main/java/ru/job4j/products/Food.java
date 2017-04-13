package ru.job4j.products;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by Anton on 12.04.2017.
 * The main class
 */
public abstract class Food {
    /**
     * Food's name.
     */
    protected String name;
    /**
     * Expire Date.
     */
    protected GregorianCalendar expireDate;
    /**
     * Create Date.
     */
    protected GregorianCalendar createDate;
    /**
     * Price.
     */
    protected int price;
    /**
     * Discount.
     */
    private int discount; // в %
    /**
     * Degree of fresh.
     */
    private double fresh;

    /**
     * Main constructor.
     * @param name food's name
     * @param createDate create Date
     * @param expireDate expire Date
     */
    public Food(String name, GregorianCalendar createDate, GregorianCalendar expireDate) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        setFresh();
        discount = 0;
        price = -1;
    }

    /**
     * Simple constructor for create PriceList.
     */
    public Food() {

    }

    /**
     * Calculate fresh from dates.
     */
    private void setFresh() { //несвежесть продукта в %
        GregorianCalendar now = new GregorianCalendar();
        long a = (now.getTimeInMillis() - this.createDate.getTimeInMillis());
        long b = (this.expireDate.getTimeInMillis() - this.createDate.getTimeInMillis());
        fresh = (double) a / b;
        //fresh = ((double) a / (double) b);
        //fresh = (new GregorianCalendar().getTimeInMillis() - this.createDate.getTimeInMillis()) / (this.expireDate.getTimeInMillis() - this.createDate.getTimeInMillis());

    }

    /**
     *
     * @return %
     */
    public double getFresh() {
        return fresh;
    }

    /**
     * Setting price.
     * @param typeOfFood setting price from Price list
     */
    public abstract void setPrice(HashMap<Food, Integer> typeOfFood);

    /**
     * Set discount.
     * @param discount from 0 to 100
     */
    public void setDiscount(int discount) {
        this.discount = discount;
        this.price = (int) ((double) this.price * (1 - (double) discount / 100));
    }

    /**
     * Getting information.
     * @return information about each type of food
     */
    public String getInformation() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy");
        return String.format("Название: %s| Дата изготовление: %s| Употребить до: %s| Цена %s| Скидка: %s%%| Несвежесть: %s%%", name, sdf.format(createDate.getTime()), sdf.format(expireDate.getTime()), price, discount, (int) (fresh * 100));
    }

}
