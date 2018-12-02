package interfaces;

/**
 * Created by AOleynikov on 02.12.2018.
 */
public interface InterfaceB {
    int a = 5;
    default void doSomething() {
        System.out.println("B");
    }
}
