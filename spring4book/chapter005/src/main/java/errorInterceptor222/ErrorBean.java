package errorInterceptor222;

/**
 * Created by AOleynikov on 11.09.2018.
 */
public class ErrorBean {
    public void errorPhoneMethod() throws Exception {
        throw new Exception("Foo");
    }

    public void otherErrorPhoneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("Bar");
    }
}
