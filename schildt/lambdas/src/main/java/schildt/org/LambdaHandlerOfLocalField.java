package schildt.org;

/**
 * Created by AOleynikov on 02.12.2018.
 */
public class LambdaHandlerOfLocalField {

    static int b = 1; // а это можно делать
    public static void main(String[] args) {
        int num = 10; // лучше писать final
        MyFunc myFunc = (n -> {
           int v = num + n;
           num++; //иначе это приведет к некомпиляции
            b++;// а это можно делать
            dod(b);// а это можно делать
            return v;
        });
        num++;//иначе это приведет к некомпиляции
        System.out.println(b);
    }

    private static int dod(int b) {
        return b++;
    }

    interface MyFunc {
        int func(int n);
    }
}
