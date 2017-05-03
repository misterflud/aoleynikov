package ru.job4j.templates;

/**
 * Created by Anton on 04.04.2017.
 */
public abstract class TemplateAction {
    abstract void start();

    abstract void finish();

    public void work() {
        this.start();
        this.finish();
    }

}
