package securityAdviceBefore211;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by AOleynikov on 10.09.2018.
 */
public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedOnUser();
        if (userInfo == null) {
            System.out.println("No user authenticated");
            throw new SecurityException(String.format("You must login before attempting to invoke the method: %s", method.getName()));
        } else if ("chris".equals(userInfo.getUserName())){
            System.out.println("Logged in user is chris - OKAY!");
        } else {
            System.out.println(String.format("Logged in user is %s NOT GOOD :(", userInfo.getUserName()));
            throw new SecurityException(String.format("User %s is not allowed access to method %s", userInfo.getUserName(), method.getName()));
        }
    }
}
