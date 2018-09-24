package proxyFactoryBeanExample265;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by AOleynikov on 24.09.2018.
 */
public class MyAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(String.format("Executing %s", method));
    }
}
