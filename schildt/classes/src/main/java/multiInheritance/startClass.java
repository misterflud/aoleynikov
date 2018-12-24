package multiInheritance;

/**
 * Created by AOleynikov on 12.12.2018.
 */
public class startClass {
    public static void main(String[] args) {
        C c = new C();
        C.D d = c.new D();
    }
}
