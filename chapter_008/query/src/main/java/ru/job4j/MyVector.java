package ru.job4j;
import java.util.Vector;

/**
 * Created by AOleynikov on 27.11.2018.
 */
class MyVector extends Vector {
    public static void main (String args[]) {
        System.out.println(setOne().toString());
    }


    protected static StringBuilder setOne() {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("Cool");
            return builder.append("Return");
        } finally {
            builder = null;
        }
    }
}
