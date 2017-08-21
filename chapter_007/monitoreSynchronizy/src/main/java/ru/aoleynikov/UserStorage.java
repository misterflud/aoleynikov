package ru.aoleynikov;

/**
 * 
 * @author Anton Oleynikov.
 * created on 07.08.2017
 */
public interface UserStorage {
	
	/**
	 * Adding.
	 * @param user user
	 */
	void add(User user);
	
	/**
	 * Updating.
	 * @param id
	 * @param amount
	 */
	void update(int id, int amount);
	
	/**
	 * Deleting.
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * Transferring.
	 * @param fromId
	 * @param toId
	 * @param amount
	 */
	void transfer(int fromId, int toId, int amount);
	
	/**
	 * Printing all users or something else.
	 */
	void print();

}
