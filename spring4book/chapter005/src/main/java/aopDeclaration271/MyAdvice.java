package aopDeclaration271;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Method;

/**
 * Created by AOleynikov on 24.09.2018.
 */
public class MyAdvice {
    public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
        if (intValue != 100) {
            System.out.println(String.format("Executing: %s %s", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName()));
        }
    }
}
