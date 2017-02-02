package ru.job4j.start;

import ru.job4j.models.Bread;
import ru.job4j.models.Item;
import ru.job4j.models.Milk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**It's main class for action something; Methods use from StartUI.
 *@author Anton Oleynikov
 *@version 1
 */
public class Tracker {
    /**
     *@param items items
     */
    private ArrayList<Item> items = new ArrayList<>();
    /**
     *@param tracker tracker
     */
    public static Tracker tracker = new Tracker();
    /**
     *@param s s
     */
    public void add(String s) {
        String[] separator = s.split(" ");
        if (separator[0].equals("Milk")) {
            tracker.items.add(new Milk(Integer.parseInt(separator[1])));
        } else {
            tracker.items.add(new Bread(Integer.parseInt(separator[1])));
        }
    }
    /**
     *@param Number Number
     */
    public void del(int Number) {
        for (int i = 0; i < tracker.items.size(); i++) {
            if (tracker.items.get(i).getCount() == Number) {
                tracker.items.remove(i);
                break;
            }
        }
    }
    /**
     *@param s s
     */
    public void change(String s) {
        String[] separator = s.split(" ");
        for (int i = 0; i < tracker.items.size(); i++) {
            if (tracker.items.get(i).getCount() == Integer.parseInt(separator[0])) {
                if (separator[1].equals("Milk")) {
                    tracker.items.set(i, new Milk(Integer.parseInt(separator[2])));
                } else {
                    tracker.items.set(i, new Bread(Integer.parseInt(separator[2])));
                }
                break;
            }
        }
    }
    /**
     *Just print.
     */
    public void printAll() {
        for (Item it : tracker.items) {
            it.printItem();
        }
    }
    /**
     *@param s s
     */
    public void filter(String s) {
        for (Item it : tracker.items) {
            if (it.getName().equals(s)) {
                it.printItem();
            }
        }
    }
    /**
     *@param s s
     */
    public void addComment(String s) {
        String[] separator = s.split(" ");
        for (int i = 0; i < tracker.items.size(); i++) {
            if (tracker.items.get(i).getCount() == Integer.parseInt(separator[0])) {
                tracker.items.get(i).setComment(s.substring(2));
                break;
            }
        }
    }
}