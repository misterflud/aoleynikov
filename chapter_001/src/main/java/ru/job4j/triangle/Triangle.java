package ru.job4j.triangle;

/**It's class for creating Triangle.
 *@author Anton Oleynikov
 *@version 1
 */
public class Triangle {
    /**Some point.
     *@param a a
     */
    private Point a;
    /**Some point.
     *@param b b
     */
    private Point b;
    /**Some point.
     *@param c c
     */
    private Point c;
    /**It's constructor.
     *@param a a
     *@param b b
     *@param c c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**It is for get distance between 2 point.
     *@return result
     */
    public double area() {
        double l1 = this.a.distanceTo(b);
        double l2 = this.a.distanceTo(c);
        double l3 = this.c.distanceTo(b);
        double p = (l1 + l2 + l3) / 2;
        double result;
        if ((l1 + l2 < l3) && (l2 + l3 < l1) && (l1 + l3 < l2)) {
            result = -1;
        } else {
            result = Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
        }
        return result;
    }
}