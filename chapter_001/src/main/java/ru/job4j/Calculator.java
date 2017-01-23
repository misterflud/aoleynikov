package ru.job4j;
/**This is Class is done sum two numbers.
 * @author Anton Oleynikov
 * @version 1
 */
public class Calculator {
    /**The field result (result is added after methods will done).
    */
    private double result;
    /**
    *@param first is number
    *@param second is number
    */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
    *@param first is number
    *@param second is number
    */
    public void substruct(double first, double second) {
        this.result = first - second;
    }
    /**
    *@param first is number
    *@param second is number
    */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
    *@param first is number
    *@param second is number
    */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**The method is returned result after methods.
    *@return result
    */
    public double getResult() {
        return this.result;
    }
}