package MethodReplacement106;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        Object result;
        if (isFormatMessageMethod(method)) {
            String msg = (String) objects[0];

            result = String.format("<h2> %s </h2>", msg);
        } else {
            throw new IllegalAccessException("Unable to reimport method" + method.getName());
        }
        return result;
    }

    private boolean isFormatMessageMethod(Method method) {
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        if (!"formatMessage".equals(method.getName())) {
            return false;
        }
        if (method.getReturnType() != String.class) {
            return false;
        }
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }
        return true;
    }
}
