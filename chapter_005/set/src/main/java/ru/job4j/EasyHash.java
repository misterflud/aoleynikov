package ru.job4j;

/**
 * Created by Anton on 25.05.2017.
 */
public class EasyHash {
    /**
     * Hashsum.
     */
    private int hash;
    /**
     * Number.
     */
    private int number;

    /**
     * Constructor.
     * @param hash
     * @param number
     */
    public EasyHash(int hash, int number) {
        this.hash = hash;
        this.number = number;
    }

    /**
     * Getter.
     * @return hash
     */
    @Override
    public int hashCode() {
        return hash;
    }

    /**
     * Getter.
     * @return number
     */
    public int getNumber() {
        return number;
    }
}
