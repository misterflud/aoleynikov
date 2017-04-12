package ru.job4j.store;

import ru.job4j.products.Food;

import java.util.ArrayList;

/**
 * Created by Anton on 12.04.2017.
 */
public abstract class Store {

    public abstract void itIsMyProductOrNot(Food food);

    public abstract void setParametersAndAddInList();

    public abstract void printAllProduct();

    public abstract void setDiscount();

    public abstract void setPrice();

    public abstract void setPriceList();
}
