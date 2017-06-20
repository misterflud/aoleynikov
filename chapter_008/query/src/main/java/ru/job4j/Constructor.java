package ru.job4j;

/**
 * Created by Anton on 20.06.2017.
 */
public interface Constructor {

    /**
     * Inserts parameters instead ?.
     */
    void fillParameters();

    /**
     * Request with ?.
     * @return String.
     */
    String getStructureRequest();

    /**
     * Request with parameters.
     * @return String.
     */
    String getRequest();
}
