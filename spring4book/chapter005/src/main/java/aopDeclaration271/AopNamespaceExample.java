package aopDeclaration271;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by AOleynikov on 24.09.2018.
 */
public class AopNamespaceExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext context = new GenericXmlApplicationContext("proxyFactoryBeanExampleConfig.xml");
//        context.refresh();
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("aopDeclarationContext271.xml");
        context.refresh();
        MyBean bean = (MyBean) context.getBean("myBean");
//        MyBean bean2 = (MyBean) context.getBean("myBean2");
        bean.execute();
    }
}
