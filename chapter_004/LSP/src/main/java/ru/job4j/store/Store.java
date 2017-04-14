package ru.job4j.store;

import ru.job4j.products.Food;


/**
 * Created by Anton on 12.04.2017.
 * Stores.
 */
public abstract class Store { //можно сделать как интерфейс, а можно добавить поля, реализовать одинаковые методы и упростить места хранения продуктов
    /**
     * Analyze which food belong me (It dependents from type of Store).
     * @param food type from Food
     */
    public abstract void takingProduct(Food food);

    /**
     *  Manage logic into Store.
     */
    public abstract void setParametersAndAddInList();

    /**
     * Printing what we have on warehouse.
     */
    public abstract void printAllProduct();

    /**
     * Setting discount.
     */
    public abstract void setDiscount();

    /**
     * Setting price.
     */
    public abstract void setPrice();

    /**
     * Create list like Food-price.
     */
    public abstract void setPriceList();
}
