package interceptor219;

/**
 * Created by AOleynikov on 11.09.2018.
 */
public class WorkerBean {
    public void doSomeWork(int noOfTimes) {
        for(int x = 0; x < noOfTimes; x++) {
            work();
        }
    }
    private void work() {
        System.out.print("");
    }
}
