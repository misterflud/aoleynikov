package ru.job4j.models;

/**It's parent class.
 *@author Anton Oleynikov
 *@version 1
 */
public class Item {
    /**
     *@param name name
     */
    private String name;
    /**
     *@param price price
     */
    private int count;
    /**
     * Request description.
     */
    private String description;
    /**
     *@param comments comment
     */
    private String[] comments;
    /**
     * Request create date.
     */
    private long create;
    /**
     * Unique id.
     */
    private String id;

    /**
     * Class constructor.
     *
     * @param name        name bug.
     * @param description short description.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor.
     */
    public Item() {

    }

    /**
     * Constructor.
     */
    public Item(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = ((Integer) id).toString();
    }
    /**
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return create date.
     */
    public long getCreate() {
        return create;
    }

    /**
     * @param create set.
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id set id.
     */
    public void setId(String id) {
        this.id = id;
    }

}
