package ru.mzto;

/**
 * Created by Anton on 15.03.2017.
 */
public interface ClientManager extends ConnectManager {
    /**
     *
     *
     * @throws Exception Exception
     */
    void manage() throws Exception; //фактически методы симметричные и этот интерфейс можно убрать, и все объединить в один.

}
