package ru.mzto;

/**
 * Created by Anton on 15.03.2017.
 */
public interface ConnectManager {
    /**
     * start program.
     * @throws Exception Exception
     */
    void getProperties() throws Exception;

    /**
     *
     * @throws Exception Exception
     */
    void connect() throws Exception;

    /**
     *
     * @param message message
     * @throws Exception Exception
     */
    void sendMessage(String message) throws Exception;

    /**
     *
     * @param fileName fileName
     * @throws Exception Exception
     */
    void sendFile(String fileName) throws Exception;

    /**
     *
     * @return String
     * @throws Exception Exception
     */
    String takeMessage() throws Exception;

    /**
     *
     * @param fileName fileName
     * @throws Exception Exception
     */
    void takeFileMessage(String fileName) throws Exception;

    /**
     *
     * @throws Exception Exception
     */
    void closeStreams() throws Exception;

}
