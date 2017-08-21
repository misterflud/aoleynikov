package ru.job4j;

import java.util.Date;

/**
 * Created by Anton on 04.07.2017.
 * Создать программу, которая будет считать количество и пробелом в тексте.
 * Необходимо создать два Thread. Первый будет считать количество слов. Второй количество пробелом в тексте.
 */
public class StatisticString {
    /**
     * Which String.
     * @param string string
     */
    public void analysis(String string, long millis) {
        System.out.println("The program counts words and spaces in two threads");
        Thread thread1 = new Thread(new Spaces(string));
        Thread thread2 = new Thread(new Words(string));
        Thread thread3 = new Thread(new TimeManagement(thread1, thread2, millis));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The program is done");
    }

    /**
     * Counts spaces.
     */
    private class Spaces implements Runnable {

        /**
         * Store.
         */
        private String string;

        /**
         * Constructor.
         * @param string string
         */
        private Spaces(String string) {
            this.string = string;
        }

        /**
         * Run.
         */
        @Override
        public void run() {
            String s = string.replaceAll("([A-Za-z0-9-]+)", "");
            System.out.println(String.format("Spaces %s", s.length()));
        }
    }
    /**
     * Counts words.
     */
    private class Words implements Runnable {
        /**
         * Store.
         */

        private String string;
        /**
         * Constructor.
         * @param string string
         */
        private Words(String string) {
            this.string = string;
        }

        /**
         * Run.
         */
        @Override
        public void run() {
            String[] s = string.split(" +");
            int count = s.length;
            if (s[0].equals("")) {
                count--;
            }
            if (s[s.length - 1].equals("")) {
                count--;
            }
            System.out.println(String.format("Words %s", count));
        }
    }

    private class TimeManagement implements Runnable {
        private long millis;

        private Thread tr1;

        private Thread tr2;

        public TimeManagement(Thread tr1, Thread tr2, long millis) {
            this.tr1 = tr1;
            this.tr2 = tr2;
            this.millis = millis;
        }

        @Override
        public void run() {
            Date date1 = new Date();
            while (true) {
                Date date2 = new Date();
                if (date2.getTime() - date1.getTime() > millis) {
                    tr1.interrupt();
                    tr2.interrupt();
                    System.out.println("The program was stopped");
                    break;
                }
                try {
                    Thread.sleep(millis / 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
