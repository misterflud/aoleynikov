package ru.job4j;

/**
 * Created by Anton on 14.02.2017.
 */
public class People {
    /**
     * brain.
     */
    private int brain;
    /**
     * health.
     */
    private int health;

    /**
     *
     * @param brain brain
     * @param health health
     */
    public People(int brain, int health) {
        this.brain = brain;
        this.health = health;
    }

    /**
     *
     * @param brain brain
     */
    public void setBrain(int brain) {
        this.brain = brain;
    }

    /**
     *
     * @return int
     */
    public int getBrain() {
        return brain;
    }

    /**
     *
     * @param health health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *
     * @return int
     */
    public int getHealth() {
        return this.health;
    }
}
