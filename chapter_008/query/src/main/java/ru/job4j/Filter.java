package ru.job4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Anton on 20.06.2017.
 */
public interface Filter {

    /**
     * Execute.
     * @param st PreparedStatement
     * @param rs ResultSet
     * @param connect Connect
     * @param conn Connection
     */
    void execute(PreparedStatement st, ResultSet rs, Connect connect, Connection conn);

    /**
     * Execute.
     * @param st PreparedStatement
     * @param conn Connection
     */
    void execute(PreparedStatement st, Connection conn);

    /**
     * Description.
     * @return String
     */
    String getRequestDescription();


}
