package ru.job4j.triangle;

/**It's class for creating point.
 *@author Anton Oleynikov
 *@version 1
 */
public class Point {
    /**It's coordination of point.
     *@param x x
     */
    private double x;
    /**It's coordination of point.
     *@param y y
     */
    private double y;
    /**It's constructor.
     *@param x x
     *@param y y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**It is for get distance between 2 point.
     *@param point Point
     *@return result
     */
    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
    }
}