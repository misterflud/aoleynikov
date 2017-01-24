package ru.job4j.loops;

/**Painting piramid of ^.
 *@author Anton Oleynikov
 *@version 1
 */
public class Paint {
    /**
     *@param h high
     *@return String String
     */
    public String piramid(int h) {
        StringBuilder n = new StringBuilder("");
        StringBuilder d = new StringBuilder("");
        StringBuilder result = new StringBuilder("");
        int count = 1;
        for (int i = 1; i <= h; i++) {
            for (int i1 = 0; i1 < h - i; i1++) {
                n.append(" ");
            }
            for (int i2 = 0; i2 <= count + 1 && i > 1; i2++) {
                d.append(" ");
            }
            if (i == 1) {
                result = result.append(n).append("^").append(n).append("\r\n");
            } else if (i == 2) {
                result = result.append(n).append("^").append(" ").append("^").append(n).append("\r\n");
            } else {
                result = result.append(n).append("^").append(d).append("^").append(n).append("\r\n");
                count += 2;
            }
            n = new StringBuilder("");
            d = new StringBuilder("");
        }
        return result.toString();
    }
}