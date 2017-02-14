package ru.job4j;

/**
 * Created by Anton on 14.02.2017.
 */
public abstract class Profession {
    /**
     * Diploma.
     */
    private String diploma;

    /**
     *
     * @param diploma diploma
     */
    public Profession(String diploma) {
        this.diploma = diploma;
    }

    /**
     *
     * @param diploma diploma
     */
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    /**
     *
     * @return String
     */
    public String getDiploma() {
        return this.diploma;
    }
}
