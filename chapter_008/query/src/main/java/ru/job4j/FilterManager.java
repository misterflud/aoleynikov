package ru.job4j;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Anton on 20.06.2017.
 */
public class FilterManager implements Closeable {

    private String url;
    private String username;
    private String password;
    ArrayList<Filter> filter = new ArrayList<>();
    private Connection conn = null;
    private PreparedStatement st;
    private ResultSet rs;

    private Connect connect;



    public FilterManager(Connect connect, String username, String password, String url) throws Exception {
        this.connect = connect;
        this.url = url;
        this.username = username;
        this.password = password;
        conn = DriverManager.getConnection(url, username, password);
    }

    public void useFilter() {

    }

    public void SelectFilter() {
        for (Filter it : filter) {
            connect.sendAnswer(it.getRequestDescription());
        }

    }

    public void AddFilter() {

    }


    class SelectConstructor extends BaseConstructor {

        public SelectConstructor(int number) {
            super(number);
        }


    }

    @Override
    public void close() throws IOException {
        try {
            conn.close();
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
