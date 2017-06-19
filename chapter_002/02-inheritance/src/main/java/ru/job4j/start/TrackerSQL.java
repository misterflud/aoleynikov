package ru.job4j.start;

import ru.job4j.models.Item;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Anton on 19.06.2017.
 */
public class TrackerSQL extends Tracker {
    /**
     * UserName.
     */
    private String username;
    /**
     * Pass.
     */
    private String password;
    /**
     * URL.
     */
    private String url;
    /**
     * Reader.
     */
    private BufferedReader reader;
    /**
     * Connection.
     */
    private Connection conn = null;
    /**
     * Statement.
     */
    private PreparedStatement st;
    /**
     *
     */
    private ResultSet rs;

    /**
     * Constructor.
     * @param username login
     * @param password pass
     * @param url url base
     * @throws Exception e
     */
    public TrackerSQL(String username, String password, String url) throws Exception {
        this.username = username;
        this.password = password;
        this.url = url;
        createTable();

    }

    /**
     * Creates table.
     * @throws Exception Exception
     */
    private void createTable() throws Exception{
        conn = DriverManager.getConnection(url, username, password);
        final Properties prs = new Properties();
        ClassLoader load = TrackerSQL.class.getClassLoader();

        reader = new BufferedReader(new InputStreamReader(load.getResourceAsStream("createusertable.sql"))); //получили скрипт создания таблицы


        st = conn.prepareStatement(reader.readLine());
        rs = st.executeQuery();

        if (!rs.next()) {
            st = conn.prepareStatement(reader.readLine());//возможно будет ошибка
            st.execute();
        }

        reader.close(); // приходится закрывать так, иначе st может быть не инициализированно. Если будет ошибка -- есть метод close в классе Tracker
    }

    /**
     * Add request to storage.
     * @param item request
     * @return ref to request
     */
    @Override
    public Item add(Item item) {
        try {
            st = conn.prepareStatement("insert into items (name, description) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.executeUpdate();
            rs = st.getGeneratedKeys();

            rs.next();

            item.setId(((Integer) rs.getInt("id")).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    /**
     * Updates item.
     * @param newItem newItem
     * @param oldId oldId
     */
    @Override
    public void update(Item newItem, String oldId) {
        try {
            st = conn.prepareStatement("update items set name = ?, description = ? where id = ?");
            st.setString(1, newItem.getName());
            st.setString(2, newItem.getDescription());
            st.setInt(3, Integer.parseInt(oldId));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes.
     * @param item item
     */
    @Override
    public void delete(Item item) {
        try {
            st = conn.prepareStatement("delete from items where id = ?");
            st.setInt(1, Integer.parseInt(item.getId()));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Filter.
     * @param name name
     * @return Item[]
     */
    @Override
    public ArrayList<Item> filterByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        try {
            st = conn.prepareStatement("select * from items where name = ?");
            st.setString(1, name);
            rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getString("name"), rs.getString("description"), rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * Finds item.
     * @param id id
     * @return Item
     */
    @Override
    public Item findById(String id) {
        Item result = null;
        try {
            st = conn.prepareStatement("select * from items where id = ?");
            st.setInt(1, Integer.parseInt(id));
            rs = st.executeQuery();
            rs.next();
            result = new Item(rs.getString("name"), rs.getString("description"), rs.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *  Gets list.
     * @return Item[]
     */
    @Override
    public ArrayList<Item> getAll() {
        ArrayList<Item> result = new ArrayList<>();
        try {
            st = conn.prepareStatement("select * from items");
            rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getString("name"), rs.getString("description"), rs.getInt("id")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * Closes.
     * @throws Exception e
     */
    @Override
    public void close() throws Exception {
        st.close();
        rs.close();
        reader.close();
    }
}
