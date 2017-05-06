package ru.job4j;

/**
 * Created by Anton on 06.05.2017.
 */
public abstract class Base {
    /**
     * Id.
     */
    protected String id;
    /**
     * Constructor.
     */
    public Base() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        setId();
    }

    /**
     * Gets id.
     * @return Id
     */
    abstract public String getId();

    /**
     * Sets Id.
     */
    abstract public void setId();
}
