package proxyFactoryBeanExample265;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by AOleynikov on 24.09.2018.
 */
public class poxyFactoryBeanExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext context = new GenericXmlApplicationContext("proxyFactoryBeanExampleConfig.xml");
//        context.refresh();
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("proxyFactoryBeanExampleConfig.xml");
        context.refresh();
        MyBean bean1 = (MyBean) context.getBean("myBean1");
        MyBean bean2 = (MyBean) context.getBean("myBean1");

        System.out.println("Bean 1");
        bean1.execute();

        System.out.println("\n Bean 2");
        bean1.execute();
    }
}
