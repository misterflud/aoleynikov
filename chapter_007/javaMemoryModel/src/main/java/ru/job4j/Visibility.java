package ru.job4j;

/**
 * Created by Anton on 13.08.2017.
 */
public class Visibility {
    /**
     * Variable for race conditions.
     */
    private volatile int c = 2;

    /**
     * Start program.
     * @param args args
     */
    public static void main(String[] args)
    {
        Visibility visibility = new Visibility();
        visibility.start();
    }

    /**
     * Start.
     */
    public void start() {

        try {
        	System.out.println(String.format("%s %s", "Begin Program", c));
            One one = new One();
            Two two = new Two();
            one.start();
            two.start();
            one.join();
            two.join();
            System.out.println(String.format("%s %s", "End Program", c));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Thread One.
     * @author Oleynikov
     *
     */
    class One extends Thread {

        /**
         * Constructor.
         */
        public One() {
            
        }

        /**
         * Run.
         */
        public void run() {
            try {
                this.sleep(10);
                c = 10;
                System.out.println(String.format("%s %s", "One", c));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    /**
     * Thread Two.
     * @author Oleynikov
     *
     */
    class Two extends Thread {

        /**
         * Constructor.
         */
        public Two() {
            
        }

        /**
         * Run.
         */
        public void run() {
            try {
                System.out.println(String.format("%s %s", "Two", c));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
