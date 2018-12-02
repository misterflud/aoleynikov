package schildt.org;

/**
 * Created by AOleynikov on 02.12.2018.
 */
public class LambdaWithGeneric {
    public static void main(String[] args) {
        MyInterface<String> myInterface = (a) -> a + 5;
        System.out.println(myInterface.func("3"));

        MyInterface<Integer> myInterface2 = (a) -> a + 5;
        System.out.println(myInterface2.func(3));
    }

    interface MyInterface<T> {
        T func(T t);
    }
}
