package aopDeclaration271;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;

/**
 * Created by AOleynikov on 24.09.2018.
 */
public class MyPointCut extends AspectJExpressionPointcut {
    public MyPointCut() {
    }

    public MyPointCut(Class<?> declarationScope, String[] paramNames, Class<?>[] paramTypes) {
        super(declarationScope, paramNames, paramTypes);
    }
}
