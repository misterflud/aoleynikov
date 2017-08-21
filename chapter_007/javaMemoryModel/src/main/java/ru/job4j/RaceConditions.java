package ru.job4j;

/**
 * Created by Anton on 13.08.2017.
 */

/**
 * Created by Anton Oleynikov on 01.08.2017.
 *
 */
public class RaceConditions
{
    /**
     * Variable for race conditions.
     */
    private int c = 2;

    /**
     * Start program.
     * @param args args
     */
    public static void main( String[] args ) //неясно почему программа зависает, ведь c хранится в каждой нити как копия????????????????
    {
        RaceConditions raceConditions = new RaceConditions();
        raceConditions.start();
    }

    /**
     * Start.
     */
    public void start() {

        try {
            //System.out.println(c);
            One one = new One();
            Two two = new Two();
            //System.out.println(c);
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
            Thread t1 = new Thread(this);
            t1.start();

        }

        /**
         * Run.
         */
        public void run() {
            try {
                System.out.println("One");
                while(true) {
                    this.sleep(10);
                    c++;
                }

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
            Thread t2 = new Thread(this);
            t2.start();
        }


        /**
         * Run.
         */
        public void run() {
            try {
                System.out.println("Two");
                while (true) {
                    this.sleep(100);
                    if (c % 2 == 0) {
                        System.out.println(c);
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}

