package ru.job4j;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Anton on 20.06.2017.
 */
public class FilterManager implements Closeable {

    /**
     * List for filters.
     */
    private ArrayList<Filter> filters = new ArrayList<>();

    /**
     * List for first position in SQL request.
     */
    private ArrayList<Constructor> firstPart = new ArrayList<>();

    /**
     * List for second position in SQL request.
     */
    private ArrayList<Constructor> secondPart = new ArrayList<>();

    /**
     * Connection with database.
     */
    private Connection conn = null;

    /**
     * Statement.
     */
    private PreparedStatement st;

    /**
     * Result request.
     */
    private ResultSet rs;

    /**
     * Connection with user.
     */
    private Connect connect;

    /**
     * Constructor.
     * @param connect connect
     * @param username username
     * @param password password
     * @param url url
     * @throws Exception Exception
     */
    public FilterManager(Connect connect, String username, String password, String url) throws Exception {
        this.connect = connect;
        conn = DriverManager.getConnection(url, username, password);
        fillLists();
    }

    /**
     * Fills lists.
     */
    public void fillLists() {
        firstPart.add(new SelectConstructorFirst(firstPart.size()));
        secondPart.add(new CriterionOne(secondPart.size()));
        secondPart.add(new CriterionTwo(secondPart.size()));
    }

    /**
     * Selects from filter's list.
     */
    public void SelectFilter() {
        connect.sendAnswer("Select filters and write number");
        for (Filter it : filters) {
            connect.sendAnswer(it.getRequestDescription());
        }
        filters.get(Integer.parseInt(connect.takeAnswer())).execute(st, rs, connect, conn);
    }

    /**
     * Adds filter in filter's list.
     */
    public void AddFilter() {
        connect.sendAnswer("Select constructor of first part of filters and write number");
        for (Constructor it : firstPart) {
            connect.sendAnswer(it.getStructureRequest());
        }
        int p1 = Integer.parseInt(connect.takeAnswer());
        firstPart.get(p1).fillParameters();

        connect.sendAnswer("Select constructor of second part of filters and write number");
        for (Constructor it : secondPart) {
            connect.sendAnswer(it.getStructureRequest());
        }
        int p2 = Integer.parseInt(connect.takeAnswer());
        secondPart.get(p2).fillParameters();

        filters.add(new UserFilter(filters.size(), firstPart.get(p1), secondPart.get(p2)));
    }

    /**
     * Part of SQL request.
     */
    class SelectConstructorFirst extends BaseConstructor {

        /**
         * Constructor.
         * @param number position
         */
        public SelectConstructorFirst(int number) {
            super(number);
            super.structureRequest = String.format("%s) %s", number, "SELECT ? FROM ?");
        }

        /**
         * Inserts parameters instead ?.
         */
        @Override
        public void fillParameters() {
            super.request = String.format("SELECT %s FROM %s", connect.sendTakeAnswer("Write first parameter"), connect.sendTakeAnswer("Write second parameter"));
        }

    }

    /**
     * Part of SQL request.
     */
    class CriterionOne extends BaseConstructor {

        /**
         * Constructor.
         * @param number position
         */
        public CriterionOne(int number) {
            super(number);
            super.structureRequest = String.format("%s) %s", number, "");
        }

        /**
         * Inserts parameters instead ?.
         */
        @Override
        public void fillParameters() {
            super.request = ";";
        }
    }

    /**
     * Part of SQL request.
     */
    class CriterionTwo extends BaseConstructor {

        /**
         * Constructor.
         * @param number position
         */
        public CriterionTwo(int number) {
            super(number);
            super.structureRequest = String.format("%s) %s", number, "WHERE ? = ?");
        }

        /**
         * Inserts parameters instead ?.
         */
        @Override
        public void fillParameters() {
            super.request = String.format("WHERE %s = %s;", connect.sendTakeAnswer("Write first parameter"), connect.sendTakeAnswer("Write second parameter"));
        }
    }

    /**
     * Closes streams.
     * @throws IOException Exceprion
     */
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
