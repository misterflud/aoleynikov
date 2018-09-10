package groovyConfiguretion195;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Created by AOleynikov on 06.09.2018.
 */
public class GroovyBeansFromJava {
    public static void main(String[] args) {
//        ApplicationContext context = new GenericGroovyApplicationContext("classpath:beans");
        ApplicationContext context = new GenericGroovyApplicationContext("SpringConfiguration/beans.groovy");
        Contact contact = context.getBean("contact", Contact.class);
        System.out.println(contact);
    }
}
