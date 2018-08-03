package autoWired118;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by AOleynikov on 01.08.2018.
 */
public class Target {

    private Foo foo;

    private Foo foo2;

    private Bar bar;

    public Target() {

    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        System.out.println("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("SpringConfiguration/autoWired118Context.xml");
        ctx.refresh();

        Target t = null;
        System.out.println("Using by name:");
        t = (Target) ctx.getBean("targetByName");
        System.out.println("Using by type:");
        t = (Target) ctx.getBean("targetByType");
        System.out.println("Using by constructor:");
        t = (Target) ctx.getBean("targetConstructor");
    }
}
