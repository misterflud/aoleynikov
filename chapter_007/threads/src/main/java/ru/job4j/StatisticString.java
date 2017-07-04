package ru.job4j;

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
    public void analysis(String string) {
        new Thread(new Spaces(string)).start();
        new Thread(new Words(string)).start();
        try { // чтобы все нити выполнились
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
}
