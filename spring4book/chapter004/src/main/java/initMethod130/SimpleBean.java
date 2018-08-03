package initMethod130;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by AOleynikov on 02.08.2018.
 */
public class SimpleBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void init() throws IllegalAccessException {
        System.out.println("Initialization bean " + this.getClass());
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalAccessException("Должно быть установлено свойство age любого бина типа" + SimpleBean.class);
        }
    }

    @Override
    public String toString() {
        return  "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("SpringConfiguration/initMethod130.xml");
        context.refresh();

        SimpleBean simpleBean1 = getBean("simpleBean1", context);
        SimpleBean simpleBean2 = getBean("simpleBean2", context);
        SimpleBean simpleBean3 = getBean("simpleBean3", context);
    }

    private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
        SimpleBean resultBean = null;
        try {
            resultBean = (SimpleBean) ctx.getBean(beanName);
            System.out.println(resultBean);
        } catch (Exception e) {
            System.out.println("An error occured in bean configuration: " + e.getMessage());
        }
        return resultBean;
    }

}
