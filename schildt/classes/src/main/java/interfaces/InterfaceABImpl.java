package interfaces;

/**
 * Created by AOleynikov on 02.12.2018.
 */
public class InterfaceABImpl implements InterfaceA, InterfaceB {
    public static void main(String[] args) {
        InterfaceABImpl interfaceAB = new InterfaceABImpl();
        interfaceAB.doSomething();
    }

    @Override
    public void doSomething() {

    }

    @Override
    public void sum(int a, int b) {

    }
}
