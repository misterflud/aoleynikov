package aoleynikov.servlets;

/**
 * Created by Anton on 15.07.2017.
 */
public class SingletonPrintOut {

    private String s = "";
    private static SingletonPrintOut ourInstance = new SingletonPrintOut();

    public static SingletonPrintOut getInstance() {
        return ourInstance;
    }

    private SingletonPrintOut() {
    }

    public void setString(String s) {
        this.s = s;
    }

    public String getString() {
        return s;
    }
}
