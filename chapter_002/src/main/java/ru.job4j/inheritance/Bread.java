package ru.job4j.inheritance;

/**It's Bread.
 *@author Anton Oleynikov
 *@version 1
 */
public class Bread extends Item {
    /**
     *@param numbers numbers
     */
    public Bread(int numbers) {
        this.name = "Bread";
        this.numbers = numbers;
        this.price = 1;
        Count count = Count.getInstance();
        this.count = count.getCountItem();
        this.comment = "";
    }
    /**
     *Each item should have printItem.
     */
    @Override
    public void printItem() {
        System.out.println("Product: " + this.name + ". How mush you are going to buy: " + this.numbers + ". How much does it cost:" + this.price * this.numbers + "$. Number you item:" + this.count + ". WARNING!! Comment:" + this.comment);
    }
}
