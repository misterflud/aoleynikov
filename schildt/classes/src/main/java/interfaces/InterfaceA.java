package interfaces;

/**
 * Created by AOleynikov on 02.12.2018.
 */
public interface InterfaceA {
    int a = 5;
    default void doSomething() {
        System.out.println("A");
    }

    void sum(int a, int b);
}
