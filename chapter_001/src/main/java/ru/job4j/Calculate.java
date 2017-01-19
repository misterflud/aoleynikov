package ru.job4j;

public class Calculate {
    public String echo(String value) {
        return String.format("%s %s %s", value, value, value);
    }
    public static void main (String[] args) throws Exception {
        Calculate cl = new Calculate();
        System.out.println(cl.echo("Something"));
    }
}


