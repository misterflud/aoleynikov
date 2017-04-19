package ru.job4j.start;

import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.Random;

/**It's main class for action something.
 *@author Anton Oleynikov
 *@version 1
 */
public class Tracker {

    /**
     * Items length.
     */
    private final int itemLength = 10;

    /**
     * Array-storage for requests.
     */
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Random.
     */
    private static final Random RN = new Random();

    /**
     * Add request to storage.
     *
     * @param item request.
     * @return ref to request.
     */
    public Item add(Item item) {
        item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
        this.items.add(item);
        return item;
    }

    /**
     *
     * @param newItem newItem.
     * @param oldId oldId.
     */
    public void update(Item newItem, String oldId) {
        for (Item item : this.items) { //по идее не должно работать, хотя будет -- ссылка не меняется, мы напрямую обращаемся к каждому Item в памяти
            if (item != null && item.getId().equals(oldId)) {
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                break;
            }
        }
    }

    /**
     *
     * @param item item.
     */
    public void delete(Item item) {
        items.remove(item);
    }

    /**
     *
     * @param name name.
     * @return Item[];
     */
    public ArrayList<Item> filterByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }
    /**
     *
     * @param id id.
     * @return Item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @return Item[].
     */
    public ArrayList<Item> getAll() {
        return items;
    }
}