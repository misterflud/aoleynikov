package aoleynikov.servlets.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import aoleynikov.servlets.model.AnonUser;
import aoleynikov.servlets.model.BaseUser;
import aoleynikov.servlets.model.User;
import aoleynikov.servlets.util.DBUtil;

import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;


/**
 * Created by Anton on 02.07.2017.
 * DAO
 */
public class ConnectionWithDataBaseDao implements AutoCloseable {

    /**
     * Basic Source.
     */
    private BasicDataSource bs;
    /**
     * Constructor.
     */
    public ConnectionWithDataBaseDao() {
        //checkTableAndCreate();
    }

    /**
     * Creates table, if it's not exist.
     */
    private void checkTableAndCreate() {
    	ClassLoader load = ConnectionWithDataBaseDao.class.getClassLoader();
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
    }

    /**
     * Creates line in BaseDate.
     * @param user user
     */
    public void createUser(BaseUser user) {
        try(Connection connection = DBUtil.getDataSource().getConnection(); 
        		PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name, login, email, createdDate) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setTimestamp(4, user.getTimeOfCreate());
            ps.execute();
        } catch (Exception e) {
			e.printStackTrace();
		}

    }

    /**
     * Edited user.
     * @param editUser editUser
     */
    public void editUser(BaseUser oldUser, BaseUser newUser) {

    }
    
    public void deleteUser(BaseUser baseUser) {
    	
    }

    /**
     * Gets users.
     * @param userWithLogin user without other parameters
     * @return user
     */
    public User getUser(BaseUser userWithLogin) {
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
        	PreparedStatement ps = connection.prepareStatement("SELECT * FROM users where login = ?")) {
    		ps.setString(1, userWithLogin.getLogin());
    		try (ResultSet rs = ps.executeQuery()) {
    			rs.next();
    			return new User(rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("createdDate"));
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}

        return null;
    }
    
    


    /**
     * Closes streams.
     * @throws Exception Exception
     */
    @Override
    public void close() throws Exception {

    }
    
    /**
     * Shows all users.
     * @return list
     */
    public ArrayList<BaseUser> getAll() {
    	ArrayList<BaseUser> list = new ArrayList<>();
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users")) {
        	try (ResultSet rs = ps.executeQuery()) {
        		while(rs.next()) {
        			list.add(new User(rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("createddate")));
        		}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        		
        } catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    
    public boolean authUser(AnonUser user) {
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?")) {
    		ps.setString(1, user.getLogin());
    		ps.setString(2, user.getPassword());
        	try (ResultSet rs = ps.executeQuery()) {
        		while(rs.next()) {
        			return true;
        		}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return false;
    }
}
