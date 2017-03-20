package ru.job4j;

/**
 * Created by Anton on 15.03.2017.
 */
public interface ClientManager extends ConnectManager {
    /**
     *
     * @param defaultDir defaultDir
     * @throws Exception Exception
     */
    void manage(String defaultDir) throws Exception; //фактически методы симметричные и этот интерфейс можно убрать, и все объединить в один.

}
