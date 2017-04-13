package ru.job4j.store;

import ru.job4j.products.Bread;
import ru.job4j.products.Food;
import ru.job4j.products.Milk;
import ru.job4j.products.Oil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anton on 12.04.2017.
 */
public class Warehouse extends Store {
    /**
     * Food.
     */
    private Food food;

    /**
     * List of food.
     */
    private ArrayList<Food> foods = new ArrayList<>();

    /**
     * Price list.
     */
    private HashMap<Food, Integer> priceList = new HashMap<>();

    /**
     * Constructor.
     */
    public Warehouse() {
        setPriceList();
    }

    /**
     * Analyze which food belong me (It dependents from type of Store).
     * @param food type from Food
     */
    @Override
    public void itIsMyProductOrNot(Food food) {
        if (food.getFresh() <= 0.25) {
            this.food = food;
            setParametersAndAddInList();
        }
    }

    /**
     *  Manage logic into Store.
     */
    @Override
    public void setParametersAndAddInList() {
        setPrice();
        this.foods.add(food);
    }

    /**
     * Printing what we have on warehouse.
     */
    @Override
    public void printAllProduct() {
        System.out.println("Warehouse:");
        for (Food iter : foods) {
            System.out.println(iter.getInformation()); //здесь печатаем описание каждого продукта
        }
    }

    /**
     * Setting discount.
     */
    @Override
    public void setDiscount() { //ничего не делает

    }

    /**
     * Setting price.
     */
    @Override
    public void setPrice() {
        food.setPrice(priceList);
    }

    /**
     * Create list like Food-price.
     */
    @Override
    public void setPriceList() { //список цен на разные продукты
        priceList.put(new Bread(), 30); //возможно стоит сделать пустой конструктор
        priceList.put(new Milk(), 60);
        priceList.put(new Oil(), 120);
    }
}
