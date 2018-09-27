package aopDeclaration271;

/**
 * Created by AOleynikov on 24.09.2018.
 */
public class MyBean {
    private MyDependency dep;

    public void execute() {
        dep.foo(100);
        dep.foo(101);
        dep.bar();
    }
    public void setDep(MyDependency dep) {
        this.dep = dep;
    }
}
