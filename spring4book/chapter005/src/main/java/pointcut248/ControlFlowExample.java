package pointcut248;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by AOleynikov on 16.09.2018.
 */
public class ControlFlowExample {
    public static void main(String[] args) {
        ControlFlowExample example = new ControlFlowExample();
        example.run();
    }

    public void run() {
        TestBean target = new TestBean();

        Pointcut pc = new ControlFlowPointcut(ControlFlowExample.class, "test");
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        TestBean proxy = (TestBean) pf.getProxy();
        System.out.println("Попытка нормального вызова");
        proxy.foo();
        // Попытка вызова из ControlFlowExample
        System.out.println("Попытка вызова из ControlFlowExample");
        test(proxy);
    }

    private void test(TestBean bean) {
        bean.foo();
    }
}
