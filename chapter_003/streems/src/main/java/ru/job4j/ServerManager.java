package ru.job4j;

/**
 * Created by Anton on 15.03.2017.
 */
public interface ServerManager extends ConnectManager  {
    /**
     *
     * @param defaultDir beginning directory
     * @throws Exception Exception
     */
    void menuStart(String defaultDir) throws Exception;

    /**
     *
     * @param dir directory
     * @return list of files
     * @throws Exception Exception
     */
    String listDir(String dir) throws Exception;

    /**
     *
     * @param dir directory
     * @throws Exception Exception
     */
    void changeDir(String dir) throws Exception;

    /**
     *
     * @throws Exception Exception
     */
    void parentDir() throws Exception;

}
