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
     * Constructor.
     * @param hash hash
     */
    public EasyHash(int hash) {
        this.hash = hash;
    }

    /**
     * Getter.
     * @return hash
     */
    @Override
    public int hashCode() {
        return hash;
    }


}
