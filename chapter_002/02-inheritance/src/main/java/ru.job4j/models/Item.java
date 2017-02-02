package ru.job4j.models;

/**It's parent class.
 *@author Anton Oleynikov
 *@version 1
 */
public class Item {
    /**
     *@param name name
     */
    protected String name;
    /**
     *@param price price
     */
    protected int price;
    /**
     *@param numbers numbers
     */
    protected int numbers;
    /**
     *@param count count
     */
    protected int count;
    /**
     *@param comment comment
     */
    protected String comment;
    /**
     *Method for children classes.
     */
    public void printItem() {

    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
