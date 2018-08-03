package CreationBean113;

/**
 * Created by AOleynikov on 30.07.2018.
 */
public class Singleton {
    private static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    public Singleton getSingleton() {
        return singleton;
    }
}
