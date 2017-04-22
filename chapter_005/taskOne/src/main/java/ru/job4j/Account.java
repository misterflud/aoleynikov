package ru.job4j;

/**
 * Created by Anton on 20.04.2017.
 */
public class Account {
    /**
     * Sum.
     */
    private double value;
    /**
     * Requisites of accounts.
     */
    private int requisites;

    /**
     * Constructor.
     * @param value value
     * @param requisites requisites
     */
    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Constructor.
     * @param requisites requisites
     */
    public Account(int requisites) { //возможно не потребуется, хотя должна быть возможность пополнять аккаунты
        this.requisites = requisites;
    }

    /**
     * Constructor.
     */
    public Account() { //пустой аккаунт нужен для хранения других аккаунтов
        this.requisites = requisites;
    }

    /**
     * Getter.
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter.
     * @param value value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Getter.
     * @return requisites
     */
    public int getRequisites() {
        return requisites;
    }
}
