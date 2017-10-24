package aoleynikov.servlets;

import org.apache.commons.dbcp2.BasicDataSource;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.activation.DataSource;

/**
 * Created by Anton on 02.07.2017.
 * DAO
 */
public class ConnectionWithDataBase implements AutoCloseable {

    /**
     * Basic Source.
     */
    private BasicDataSource bs;
    /**
     * Constructor.
     */
    public ConnectionWithDataBase() {
        checkTableAndCreate();
    }

    /**
     * Creates table, if it's not exist.
     */
    private void checkTableAndCreate() {
    	ClassLoader load = ConnectionWithDataBase.class.getClassLoader();
        try (Connection connection = DBUtil.getDataSource().getConnection(); 
        		BufferedReader reader = new BufferedReader(new InputStreamReader(load.getResourceAsStream("createusertable.sql"))); 
        		PreparedStatement ps = connection.prepareStatement(reader.readLine());
        		ResultSet rs = ps.executeQuery();) { //получили скрипт создания таблицы
            
         
            if (!rs.next()) {
                 connection.prepareStatement(reader.readLine()).execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
/*
  try{
            Class.forName("org.postgresql.Driver");
            bs = new BasicDataSource();
            bs.setUrl(url);
            bs.setUsername(username);
            bs.setPassword(password);
            bs.setMinIdle(5);
            bs.setMaxIdle(10);
            bs.setMaxOpenPreparedStatements(100);

            connection = bs.getConnection();
            ClassLoader load = ConnectionWithDataBase.class.getClassLoader();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(load.getResourceAsStream("createusertable.sql")))) { //получили скрипт создания таблицы
                st = connection.prepareStatement(reader.readLine());
                rs = st.executeQuery();
                if (!rs.next()) {
                    connection.prepareStatement(reader.readLine()).execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 */
    }

    /**
     * Creates line in BaseDate.
     * @param user user
     */
    public void createUser(BaseUser user) {
        try(Connection connection = DBUtil.getDataSource().getConnection(); 
        		PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name, login, email, createdDate) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, user.name);
            ps.setString(2, user.login);
            ps.setString(3, user.email);
            ps.setTimestamp(4, user.timeOfCreate);
            ps.execute();
        } catch (Exception e) {
			e.printStackTrace();
		}
        /*
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
         */

    }

    /**
     * Edited user.
     * @param editUser editUser
     */
    public void editUser(BaseUser editUser) {
    	/*
        try {
            st = connection.prepareStatement("UPDATE users SET name = ? WHERE login = ? AND email = ?");
            st.setString(1, editUser.name);
            st.setString(2, editUser.login);
            st.setString(3, editUser.email);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    /**
     * Gets users.
     * @param userWithLogin user without other parameters
     * @return user
     */
    public User getUser(BaseUser userWithLogin) {
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
        	PreparedStatement ps = connection.prepareStatement("SELECT * FROM users where login = ?")) {
    		ps.setString(1, userWithLogin.login);
    		try (ResultSet rs = ps.executeQuery()) {
    			rs.next();
    			return new User(rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("createdDate"));
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	/*
        try {
            st = connection.prepareStatement("SELECT * FROM users where login = ?");
            st.setString(1, userWithLogin.login);
            rs = st.executeQuery();
            rs.next();
            return new User(rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("createdDate"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        return null;
    }

    /**
     * Deletes user.
     * @param userWithLogin user without other parameters
     */
    public void deleteUser(BaseUser userWithLogin) {
    	/*
        try {
            st = connection.prepareStatement("DELETE FROM users where login = ?");
            st.setString(1, userWithLogin.login);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
    
    private void refreshConnection() {
		
	}

    /**
     * Closes streams.
     * @throws Exception Exception
     */
    @Override
    public void close() throws Exception {
    	/*
        st.close();
        rs.close();
        connection.close();
        */
    }
}
