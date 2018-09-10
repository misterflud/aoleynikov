package aop202;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by AOleynikov on 07.09.2018.
 */
public class MessageDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello");
        Object retVal = methodInvocation.proceed();
        System.out.println("!");
        return retVal;
    }
}
