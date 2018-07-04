package com.metanit.simple;

public class LambdaOne {
    public static void main(String[] args) {
        // не блочные лямбды:
        Operational operation;
        operation = (x,y)->  x + y;
        Printable printable;
        printable = (String s) -> System.out.println(s);
        int result = operation.calculate(10, 20);
        System.out.println(result); //30
        printable.print("aaaaaaaaaaaaaaaa");


        Operational operational_2 = (x, y) -> {// блочная лямбды:
            int g = 9;

            return x * y * g;
        };
        printable.print(String.valueOf(operational_2.calculate(4, 3)));


        Operational2<String> operational_String = (x, y) -> x + y;
        Operational2<Integer> operational_Integer = (x, y) -> x + y;

        printable.print(operational_String.calculate("2", "2"));
        printable.print(String.valueOf(operational_Integer.calculate(2, 2)));

    }

    interface Operational { //функциональный интерфейс
        int calculate(int x, int y);
    }


    interface Printable{ // для терминальной лямбды
        void print(String s);
    }

    interface Operational2<T> { //Обобщенный функциональный интерфейс
        T calculate(T x, T y);
    }
}
