package staticPointcut229;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created by AOleynikov on 12.09.2018.
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("foo".equals((method.getName())));
    }

    @Override //необязательно переопределять, но в этом случае мы фильтруем по нужному нам классу
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return (aClass == BeanOne.class);
            }
        };
    }
}
