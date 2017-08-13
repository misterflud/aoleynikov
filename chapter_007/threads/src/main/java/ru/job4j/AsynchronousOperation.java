package ru.job4j;

/**
 * Created by Anton on 04.07.2017.
 */
public class AsynchronousOperation {

    public static final class Calculate implements Runnable {

        private String name;

        public Calculate(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            AsynchronousOperation a = new AsynchronousOperation();
            a.print(name);

        }
    }
    public static void main(String[] args) {
        new Thread(new Calculate("Thread1 ")).start();
        new Thread(new Calculate("Thread2 ")).start();
        /*
        //анонимный класс
        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread3");
            }
        }.start();
        */
    }

    public void print(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + i);
        }
    }
}
