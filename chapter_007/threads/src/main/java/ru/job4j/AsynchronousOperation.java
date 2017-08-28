package ru.job4j;

/**
 * Created by Anton on 04.07.2017.
 */
public class AsynchronousOperation {

	/**
	 * Inner class.
	 * @author Anton Oleynikov
	 * created on 28.08.2017
	 */
    public static final class Calculate implements Runnable {
    	/**
    	 * Name of thread.
    	 */
        private String name;

        /**
         * Constructor.
         * @param name
         */
        public Calculate(String name) {
            this.name = name;
        }
        
        /**
         * Run.
         */
        @Override
        public void run() {
            AsynchronousOperation a = new AsynchronousOperation();
            a.print(name);

        }
    }
    
    /**
     * Start program.
     * @param args
     */
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

    /**
     * Printing name of thread and iteration.
     * @param name
     */
    public void print(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + i);
        }
    }
}
