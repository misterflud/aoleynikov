package mySpringProperty164;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by AOleynikov on 26.08.2018.
 */
public class CustomEditorExample {
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("SpringConfiguration/mySpringProperty164.xml");
        ctx.refresh();
        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
    }
}
