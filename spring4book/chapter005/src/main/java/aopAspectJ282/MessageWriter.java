package aopAspectJ282;

/**
 * Created by AOleynikov on 26.09.2018.
 */
public class MessageWriter {
    public void writeMessage() {
        System.out.println("foobar!");
    }

    public void foo() {
        System.out.println("foo");
    }
}
