package ru.job4j.inheritance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**It's main class for management console program.
 *Example '<Milk> + <12>', it's mean that you should write: Milk 12
 *@author Anton Oleynikov
 *@version 1
 */
public class Tracker {
    /**
     *@param items items
     */
    public ArrayList<Item> items = new ArrayList<>();
    /**
     *@param tracker tracker
     */
    public static Tracker tracker = new Tracker();
    /**
     *@param args from console
     *@exception Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in;
        boolean exit = true;
        while (exit) {
            System.out.println("..................Menu.................." + "\r\n" + "1 - add new Item;"  + "\r\n" + "2 - delete Item;"  + "\r\n" + "3 - change Item;"  + "\r\n" + "4 - Print all;"  + "\r\n" + "5 - Filter;"  + "\r\n" + "6 - add commit;"  + "\r\n" + "7 - END;"  + "\r\n");
            in = reader.readLine();
            switch (in) {
                case "1" :
                    System.out.println("Write <Product's type(Milk or Bread)> + <Numbers>");
                    tracker.add(reader.readLine());
                    break;
                case "2" :
                    System.out.println("Write item's number and it will be deleted");
                    tracker.del(Integer.parseInt(reader.readLine()));
                    break;
                case "3" :
                    System.out.println("Write <item's number(Count)> + <new Name of type product's> + <new number (How mush you are going to buy)> and it will be changed");
                    tracker.change(reader.readLine());
                    break;
                case "4" :
                    System.out.print("Print all items, loaded");
                    Thread.sleep(1000);
                    System.out.print("..");
                    Thread.sleep(1000);
                    System.out.print("...");
                    Thread.sleep(1000);
                    System.out.println("..");
                    tracker.printAll();
                    break;
                case "5" :
                    System.out.println("Print Bread's item or Milk's item, what you wish" + "\r\n" + "Write <Item(Milk or Bread)>");
                    tracker.filter(reader.readLine());
                    break;
                case "6" :
                    System.out.println("You can write comments" + "\r\n" + "Write <item's number(Count)> + <comment>");
                    tracker.filter(reader.readLine());
                    break;
                case "7" :
                    System.out.println("................THE END.................");
                    Thread.sleep(2000);
                    exit = false;
                    break;
            }
        }
    }
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
            if (tracker.items.get(i).count == Number) {
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
            if (tracker.items.get(i).count == Integer.parseInt(separator[0])) {
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
            if (it.name.equals(s)) {
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
            if (tracker.items.get(i).count == Integer.parseInt(separator[0])) {
                tracker.items.get(i).comment = separator[1];
                break;
            }
        }
    }
}