package schildt.org;

/**
 * Created by AOleynikov on 02.12.2018.
 */
public class SendLambda {
    public static void main(String[] args) {
        StringFunc stringFunc = (n) -> n + " it's working!!!";
        System.out.println(stringOp(stringFunc, "working?"));

        System.out.println(
                stringOp((n) -> n + "oops"
        ,"asd"));
    }

    private static String stringOp(StringFunc stringFunc, String s) {
        return stringFunc.func(s);
    }
    interface StringFunc {
        String func(String n);
    }
}
