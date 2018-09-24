package introduction259;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by AOleynikov on 17.09.2018.
 */
public class IntroductionExample {
    public static void main(String[] args) {
        TargetBean targetBean = new TargetBean();
        targetBean.setName("Chris Schaefer");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(targetBean);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        TargetBean proxy = (TargetBean) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.println(String.format("Is TargetBean?: %s", proxy instanceof TargetBean));
        System.out.println(String.format("Is IsModified?: %s", proxy instanceof IsModified));
        System.out.println(String.format("Has been modified?: %s", proxyInterface.isModified()));

        proxy.setName("Chris Schaefer");
        System.out.println(String.format("Has been modified?: %s", proxyInterface.isModified()));
        proxy.setName("Bla bla bla");
        System.out.println(String.format("Has been modified?: %s", proxyInterface.isModified()));

    }
}
