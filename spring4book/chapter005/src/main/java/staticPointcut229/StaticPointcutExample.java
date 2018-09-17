package staticPointcut229;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by AOleynikov on 12.09.2018.
 */
public class StaticPointcutExample {
    public static void main(String[] args) {
        BeanOne beanOne = new BeanOne();
        BeanTwo beanTwo = new BeanTwo();

        BeanOne proxyOne;
        BeanTwo proxyTwo;

        Pointcut pointcut = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactoryOne = new ProxyFactory();
        proxyFactoryOne.addAdvisor(advisor);
        proxyFactoryOne.setTarget(beanOne);
        proxyOne = (BeanOne) proxyFactoryOne.getProxy();

        ProxyFactory proxyFactoryTwo = new ProxyFactory();
        proxyFactoryTwo.addAdvisor(advisor);
        proxyFactoryTwo.setTarget(beanTwo);
        proxyTwo = (BeanTwo) proxyFactoryTwo.getProxy();

        proxyOne.foo();
        proxyTwo.foo();

        proxyOne.bar();
        proxyTwo.foo();
    }
}
