package securityAdviceBefore211;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by AOleynikov on 10.09.2018.
 */
public class SecurityExample {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();
        SecureBean bean = getSecureBean();
        manager.login("chris", "pwd");
        bean.writeSecureMessage();
        manager.logout();
        try {
            manager.login("invaliduser", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println(String.format("Exception Caught: %s", e.getMessage()));
        } finally {
            manager.logout();
        }
        try {
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println(String.format("Exception Caught: %s", e.getMessage()));
        }

    }


    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        SecureBean proxy = (SecureBean) factory.getProxy();
        return proxy;
    }
}
