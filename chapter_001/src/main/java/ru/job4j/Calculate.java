package ru.job4j;
/**
 *This is Class is created three string from one string
 * @author Anton
 * @version 3
 */
public class Calculate {
    /**
     *
     * @param value just string
     * @return concatenations three parameters and two spaces between their
     */
    public String echo(String value) {
        return String.format("%s %s %s", value, value, value);
    }
    public static void main (String[] args) throws Exception {
        Calculate cl = new Calculate();
        System.out.println(cl.echo("Something"));
    }
}


