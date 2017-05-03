package ru.job4j.templates;

/**
 * Created by Anton on 04.04.2017.
 */
public class Start {
    public static void main(String[] args) {
        new CopyAction().work();
        new TemplateAction() {
            public void start() {
                System.out.println("start2");
            }

            public void finish() {
                System.out.println("finish2");
            }
        };
    }


}
