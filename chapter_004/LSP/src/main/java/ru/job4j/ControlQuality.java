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
    /**
     * Food list.
     */
    private ArrayList<Food> foods;
    /**
     * Stores list.
     */
    private ArrayList<Store> stores = new ArrayList<>();

    /**
     * Constructor.
     */
    public ControlQuality() {
        setStoreList();
    }

    /**
     * Create Stores list.
     */
    public void setStoreList() {
        stores.add(new Trash());
        stores.add(new Shop());
        stores.add(new Warehouse());
    }

    /**
     * Take food list.
     * @param foods foods
     */
    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    /**
     * Control.
     */
    public void control() { //добавление по хранилищам
        for (Food iter1 : foods) {
            for (Store iter2 : stores) {
                iter2.takingProduct(iter1);
            }
        }
    }

    /**
     * Print all product in all Stores.
     */
    public void printWhatWeHave() {
        for (Store iter : stores) {
            iter.printAllProduct();
        }
    }
}
