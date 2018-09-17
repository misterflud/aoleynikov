package interceptor219;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * Created by AOleynikov on 11.09.2018.
 */
public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(methodInvocation.getMethod().getName());

        Object returnValue = methodInvocation.proceed();

        stopWatch.stop();
        dumpInfo(methodInvocation, stopWatch.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation methodInvocation, long ms) {
        Method method = methodInvocation.getMethod();
        Object target = methodInvocation.getThis();
        Object[] args = methodInvocation.getArguments();

        System.out.println(String.format("Execute method: %s", method.getName()));
        System.out.println(String.format("Execute method: %s", target.getClass().getName()));
        System.out.println("With argument: ");
        for (Object o : args) {
            System.out.print(String.format("      > %s", args));
        }
        System.out.print("\n");
        System.out.println(String.format("Took: %s ms", ms));
    }
}
