package aoleynikov.servlets.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import aoleynikov.servlets.model.AnonUser;
import aoleynikov.servlets.model.BaseUser;
import aoleynikov.servlets.model.GeteerRole;
import aoleynikov.servlets.model.Role;
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
        		PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name, login, email, createddate, password, role_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setTimestamp(4, user.getTimeOfCreate());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getUserRole().getId());
            
            ps.execute();
        } catch (Exception e) {
			e.printStackTrace();
		}

    }

    /**
     * Edited user.
     * @param editUser editUser
     */
    public void editUser(BaseUser editUser) {
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE USERS SET NAME = ?, EMAIL = ?, ROLE_ID = ? WHERE LOGIN = ?")) {
    		
    		pStatement.setString(1, editUser.getName());
    		pStatement.setString(2, editUser.getEmail());
    		pStatement.setInt(3, editUser.getUserRole().getId());
    		pStatement.setString(4, editUser.getLogin());
    		pStatement.execute();

    		//pStatement.executeQuery();
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    }
    
    /**
     * Deletes user.
     * @param baseUser BaseUser
     */
    public void deleteUser(BaseUser baseUser) {
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
    		PreparedStatement ps = connection.prepareStatement("DELETE FROM USERS WHERE LOGIN = ?")) {
    		System.out.println(baseUser.getLogin());
    		ps.setString(1, baseUser.getLogin());
    		ps.executeUpdate();
    	} catch (Exception e) {
			e.printStackTrace();
		}
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
    			GeteerRole geteerRole = new GeteerRole();

    			return new User(rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("createdDate"), geteerRole.getRole(rs.getInt("role_id")));
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
    	GeteerRole geteerRole = new GeteerRole();
    	ArrayList<BaseUser> list = new ArrayList<>();
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users")) {
        	try (ResultSet rs = ps.executeQuery()) {
        		while(rs.next()) {
        			list.add(new User(rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("createddate"), geteerRole.getRole(rs.getInt("role_id"))));
        		}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        		
        } catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    
    /**
     * Authentications user.
     * @param user user
     * @return boolean
     */
    public boolean authUser(AnonUser user) {
    	try(Connection connection = DBUtil.getDataSource().getConnection(); 
        PreparedStatement ps = connection.prepareStatement("SELECT EXISTS (SELECT * FROM  USERS WHERE login = ? and password = ?) as yes_or_no")) {
    		ps.setString(1, user.getLogin());
    		ps.setString(2, user.getPassword());
        	try (ResultSet rs = ps.executeQuery()) {
        		rs.next();
        		return rs.getBoolean("yes_or_no");

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
