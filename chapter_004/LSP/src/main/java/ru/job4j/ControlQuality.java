package ru.job4j;

import ru.job4j.products.Food;
import ru.job4j.store.Shop;
import ru.job4j.store.Store;
import ru.job4j.store.Trash;
import ru.job4j.store.Warehouse;

import java.util.ArrayList;

/**
 * Created by Anton on 12.04.2017.
 */
public class ControlQuality {

    private ArrayList<Food> foods;
    private ArrayList<Store> stores = new ArrayList<>();

    public ControlQuality() {
        setStoreList();
    }

    public void setStoreList() {
        stores.add(new Trash());
        stores.add(new Shop());
        stores.add(new Warehouse());
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
    public void control() { //добавление по хранилищам
        for(Food iter1 : foods) {
            for(Store iter2 : stores) {
                iter2.itIsMyProductOrNot(iter1);
            }
        }
    }

    public void printWhatWeHave() {
        for(Store iter : stores) {
            iter.printAllProduct();
        }
    }
}
