package ru.job4j;

/**
 * Created by Anton on 20.06.2017.
 */
public abstract class BaseConstructor implements Constructor {

    /**
     * Description with some rubbish.
     */
    protected String structureRequest;

    /**
     * Clean SQL request.
     */
    protected String request;

    /**
     * Position in list.
     */
    protected int number;

    /**
     * Constructor.
     * @param number position
     */
    public BaseConstructor(int number) {
        this.number = number;
    }

    /**
     * Getter.
     * @return String
     */
    @Override
    public String getStructureRequest() {
        return structureRequest;
    }

    /**
     * Getter.
     * @return String
     */
    @Override
    public String getRequest() {
        return request;
    }

}
