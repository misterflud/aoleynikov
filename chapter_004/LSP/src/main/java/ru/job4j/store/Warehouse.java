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
public class Warehouse extends Store{


    private Food food;
    private ArrayList<Food> foods = new ArrayList<>();
    private HashMap<Food, Integer> priceList = new HashMap<>();

    public Warehouse() {
        setPriceList();
    }

    @Override
    public void itIsMyProductOrNot(Food food) {
        if (food.getFresh() <= 0.25) {
            this.food = food;
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
        System.out.println("Warehouse:");
        for (Food iter : foods) {
            System.out.println(iter.getInformation()); //здесь печатаем описание каждого продукта
        }
    }

    @Override
    public void setDiscount() { //ничего не делает

    }

    @Override
    public void setPrice() {
        food.setPrice(priceList);
    }

    @Override
    public void setPriceList() { //список цен на разные продукты
        priceList.put(new Bread(), 30); //возможно стоит сделать пустой конструктор
        priceList.put(new Milk(), 60);
        priceList.put(new Oil(), 120);
    }
}
