package org.annotation.single345;

/**
 * Created by AOleynikov on 24.07.2018.
 */
public class UsingSingleValue {

    public static void main(String[] args) {
        testSingle();
    }

    @SingleAnno(51)
    public static void testSingle() {
        try {
            System.out.println((new UsingSingleValue()).getClass().getMethod("testSingle").getAnnotation(SingleAnno.class).value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
