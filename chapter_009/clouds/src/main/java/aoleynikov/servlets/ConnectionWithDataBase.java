package aoleynikov.servlets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Anton on 02.07.2017.
 */
public class ConnectionWithDataBase implements AutoCloseable {

    private String username;

    private String password;

    private String url;

    private Connection connection;

    private PreparedStatement st;

    private ResultSet rs;

    private BufferedReader reader;

    public ConnectionWithDataBase(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
        checkTableAndCreate();
    }

    private void checkTableAndCreate() {
        try {
            connection = DriverManager.getConnection(url, username, password);

            final Properties prs = new Properties();
            ClassLoader load = ConnectionWithDataBase.class.getClassLoader();
            reader = new BufferedReader(new InputStreamReader(load.getResourceAsStream("createusertable.sql"))); //получили скрипт создания таблицы

            st = connection.prepareStatement(reader.readLine());
            rs = st.executeQuery();
            if (!rs.next()) {
                connection.prepareStatement(reader.readLine()).execute();
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createUser(BaseUser user) {
        try {
            st = connection.prepareStatement("INSERT INTO users(name, login, email, createdDate) VALUES (?, ?, ?, ?)");
            st.setString(1, user.name);
            st.setString(2, user.login);
            st.setString(3, user.email);
            st.setTimestamp(4, user.timeOfCreate);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editUser(BaseUser editUser) {
        try {
            st = connection.prepareStatement("UPDATE users SET name = ? WHERE login = ? AND email = ?");
            st.setString(1, editUser.name);
            st.setString(2, editUser.login);
            st.setString(3, editUser.email);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BaseUser getUser(BaseUser userWithLogin) {
        try {
            st = connection.prepareStatement("SELECT * FROM users where login = ?");
            st.setString(1, userWithLogin.login);
            rs = st.executeQuery();
            rs.next();
            return new User(rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("createdDate"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUser(BaseUser userWithLogin) {
        try {
            st = connection.prepareStatement("DELETE * FROM users where login = ?");
            st.setString(1, userWithLogin.login);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        st.close();
        reader.close();
        connection.close();
        reader.close();
    }
}
