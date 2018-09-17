package errorInterceptor222;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by AOleynikov on 11.09.2018.
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {
    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();

        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(errorBean);
        pf.addAdvice(new SimpleThrowsAdvice());

        ErrorBean proxy = (ErrorBean) pf.getProxy();

        try {
            proxy.errorPhoneMethod();
        } catch (Exception e) {

        }
        try {
            proxy.otherErrorPhoneMethod();
        } catch (Exception e) {

        }

    }


    public void afterThrowing(Exception e) throws Throwable {
        System.out.println("***");
        System.out.println("Generic exception capture");
        System.out.println(String.format("Caught: %s", e.getClass().getName()));
        System.out.println("****\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException e) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println(String.format("Caught: %s", e.getClass().getName()));
        System.out.println(String.format("Method: %s", method.getName()));
        System.out.println("****\n");
    }
}
