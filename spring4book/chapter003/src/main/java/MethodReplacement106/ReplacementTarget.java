package MethodReplacement106;


public class ReplacementTarget {
    public String formatMessage(String msg) {
        return String.format("<h1> %s </h1>", msg);
    }

    public String formatMessage(Object msg) {
        return String.format("<h1> %s </h1>", msg);
    }
}
