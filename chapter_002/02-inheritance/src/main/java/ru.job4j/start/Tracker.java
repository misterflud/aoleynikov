package ru.job4j.start;

import ru.job4j.models.Item;

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
    private Item[] items = new Item[itemLength];
    /**
     * Index of request.
     */
    private int position = 0;
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
        this.items[position++] = item;
        return item;
    }

    /**
     *
     * @param newItem newItem.
     * @param oldId oldId.
     */
    public void update(Item newItem, String oldId) {
        for (Item item : this.items) {
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
        int index = -1;
        for (int i = 0; i <= this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                index = i;
                break;
            }
        }
        this.items[index] = null;
        this.position--;
    }
    /**
     * Print all requests.
     *
     * @return all requests.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     *
     * @param key key.
     * @return Item[];
     */
    public Item[] filterByName(String key) {
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                count++;
            }
        }

        int count2 = 0;
        Item[] result = new Item[count];
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result[count2++] = item;
            }
        }
        return result;
    }
    /**
     *
     * @param id id.
     * @return Item.
     */
    protected Item findById(String id) {
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
     * @param items items.

    public void print(Item[] items) {
        for (Item item : items) {
            System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
        }
    }

    /**
     *
     * @param item item.

    public void print(Item item) {
        System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
    }
    */
}