package ru.job4j;

/**
 *  Created by Anton on 06.05.2017.
 * @param <T> type
 */
public abstract class MainStore<T extends Base> implements Store<T> {
    /**
     * Container.
     */
    private SimpleArray <T> simpleArray;
    /**
     * Size of container.
     */
    private int size;

    /**
     * Constructor.
     * @param size size
     */
    public MainStore(int size) {
        this.size = size;
        simpleArray = new <T> SimpleArray(size); //что это значит? unchecked assignment -- почему unchecked если я явно указываю какой тип я ожидаю <T>
    }
    /**
     * Adds something.
     * @param t t
     */
    @Override
    public void add(T t){
        simpleArray.add(t);
    }
    /**
     * Deletes  something.
     * @param id id
     */
    @Override
    public void delete(String id) {
        for (int i = 0; i < size; i++) {
            if (simpleArray.get(i) != null) {
                if (simpleArray.get(i).getId().equals(id)) {
                    simpleArray.delete(i);
                    break;
                }
            }
        }
    }
    /**
     * Update something.
     * @param id id
     * @param t t
     */
    @Override
    public void update(String id, T t){
        for (int i = 0; i < size; i++) {
            if (simpleArray.get(i) != null) {
                if (simpleArray.get(i).getId().equals(id)) {
                    simpleArray.delete(i);
                    simpleArray.add(t);
                    break;
                }
            }
        }
    }

    /**
     * Prints.
     */
    public void printAll() {
        for (int i = 0; i < size; i++) {
            if (simpleArray.get(i) != null) {
                System.out.println(simpleArray.get(i).getId());
            }
        }
    }
}
