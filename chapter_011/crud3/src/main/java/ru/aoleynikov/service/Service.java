package ru.aoleynikov.service;

import java.awt.List;
import java.util.ArrayList;

import ru.aoleynikov.model.AnonUser;
import ru.aoleynikov.model.BaseUser;
import ru.aoleynikov.dao.ConnectionWithDataBaseDao;
import ru.aoleynikov.model.User;

/**
 * Service class.
 * @author Anton Oleynikov
 * created on 30.11.2017
 */
public class Service {
	
	/**
	 * Service for get user.
	 * @param user user
	 * @return
	 */
	public BaseUser get(BaseUser user) {
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
	
	/**
	 * Service for authentication user.
	 * @param user user
	 * @return boolean
	 */
	public boolean authUser(AnonUser user) {
		return new ConnectionWithDataBaseDao().authUser(user);
	}
	/**
	 * Service for deletes user.
	 * @param user user
	 */
	public void deleteUser(BaseUser user) {
		new ConnectionWithDataBaseDao().deleteUser(user);
	}

	/**
	 * Service for edit user.
	 * @param editUser
	 */
	public void editUser(BaseUser editUser) {
		new ConnectionWithDataBaseDao().editUser(editUser);
	}
	
}
