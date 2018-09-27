package aopDeclaration271;

/**
 * Created by AOleynikov on 24.09.2018.
 */
public class MyDependency {
    public void foo(int intValue) {
        System.out.println(String.format("foo(): %s", intValue));
    }

    public void bar() {
        System.out.println("bar()");
    }
}
