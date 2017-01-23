package ru.job4j;
/**This is Class is done sum two numbers.
 * @author Anton Oleynikov
 * @version 1
 */
public class Calculator {
    /**The field result (result is added after method add() will done).
    */
    private double result;
    /**The main method.
    *@param first is number
    *@param second is number
    */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**The method is returned result after method add.
    * @return result
    */
    public double getResult() {
        return this.result;
    }
}