package aoleynikov.servlets.service;

import java.awt.List;
import java.util.ArrayList;

import aoleynikov.servlets.model.BaseUser;
import aoleynikov.servlets.dao.ConnectionWithDataBaseDao;
import aoleynikov.servlets.model.User;

public class Service {
	
	/**
	 * Service for get user.
	 * @param user user
	 * @return
	 */
	public BaseUser get(User user) {
		return new ConnectionWithDataBaseDao().getUser(user);
	}
	
	/**
	 * Service for get all users.
	 * @return list
	 */
	public ArrayList<BaseUser> getAll() {
		return new ConnectionWithDataBaseDao().getAll();
	}
	
	/**
	 * Service for add user.
	 * @param user user
	 */
	public void addUser(BaseUser user) {
		new ConnectionWithDataBaseDao().createUser(user);
	}
}
