package staticPointcut229;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by AOleynikov on 12.09.2018.
 */
public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
         System.out.println(String.format(">> Invoking %s", methodInvocation.getMethod().getName()));
         Object retVal = methodInvocation.proceed();
         System.out.println(">> Done ");
         return retVal;
    }
}
