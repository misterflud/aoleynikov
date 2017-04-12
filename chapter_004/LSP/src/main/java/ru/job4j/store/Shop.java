package ru.job4j.store;

import ru.job4j.products.Bread;
import ru.job4j.products.Food;
import ru.job4j.products.Milk;
import ru.job4j.products.Oil;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;


/**
 * Created by Anton on 12.04.2017.
 */
public class Shop extends Store {

    private Food food;
    private ArrayList<Food> foods = new ArrayList<>();
    private HashMap<Food, Integer> priceList = new HashMap<>();

    public Shop() {
        setPriceList();
    }

    @Override
    public void itIsMyProductOrNot(Food food) {
        if (food.getFresh() > 0.25 && food.getFresh() <= 0.75) {
            this.food = food;
            setParametersAndAddInList();
        } if (food.getFresh() > 0.75 && food.getFresh() <= 100) {
            this.food = food;
            setDiscount();
            setParametersAndAddInList();
        }
    }

    @Override
    public void setParametersAndAddInList() {
        setPrice();
        this.foods.add(food);
    }

    @Override
    public void printAllProduct() {
        System.out.println("Shop:");
        for (Food iter : foods) {
            System.out.println(iter.getInformation()); //здесь печатаем описание каждого продукта
        }
    }

    @Override
    public void setDiscount() {
        this.food.setDiscount(23);
    }

    @Override
    public void setPrice() {
        food.setPrice(priceList);
    }

    @Override
    public void setPriceList() { //список цен на разные продукты
        priceList.put(new Bread(), 20); //возможно стоит сделать пустой конструктор
        priceList.put(new Milk(), 42);
        priceList.put(new Oil(), 100);
    }
}
