package CreationBean113;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by AOleynikov on 30.07.2018.
 */
public class UsingDifferentTypeOfBean {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("SpringConfiguration/context5.xml");
        ctx.refresh();
        UsualObject springSingleton1 = (UsualObject) ctx.getBean("springSingleton");
        UsualObject springSingleton2 = (UsualObject) ctx.getBean("springSingleton");
        springSingleton1.setName("11111");

        UsualObject nonSingleton1 = (UsualObject) ctx.getBean("nonSingleton");
        UsualObject nonSingleton2 = (UsualObject) ctx.getBean("nonSingleton");

        nonSingleton1.setName("11111");

        System.out.println(String.format("SpringSingleton %s", springSingleton2.getName()));
        System.out.println(String.format("SpringSingleton real singleton? %s", springSingleton1.equals(springSingleton2)));

        System.out.println(String.format("NonSingleton %s", nonSingleton2.getName()));
        System.out.println(String.format("NonSingleton real singleton? %s", nonSingleton1.equals(nonSingleton2)));

    }
}
