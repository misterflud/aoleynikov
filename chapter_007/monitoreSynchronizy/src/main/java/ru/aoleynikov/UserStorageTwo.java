package ru.aoleynikov;

import java.util.HashMap;
import java.util.Map.Entry;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Storage on my thread safe.
 * @author Anton Oleynikov
 * created on 07.08.2017
 */
public class UserStorageTwo implements UserStorage {
	
	/**
	 * List of Users.
	 */
	private static HashMap<Integer, User> list = new HashMap<>(); //Ставить ли volatile?????
	
	/**
	 * Monitor0.
	 */
	private Integer monitor0 = new Integer(-10); //проранжирвоали по важности операции. Трансфер самый важный поэтому он выполняется в любом случае первый
	
	/**
	 * Monitor1.
	 */
	private Integer monitor1 = new Integer(-1);
	
	/**
	 * Monitor2.
	 */
	private Integer monitor2 = new Integer(-2);
	
	
	/**
	 * Monitor3.
	 */
	private Integer monitor3 = new Integer(-3);
	
	/**
	 * Monitor4.
	 */
	private Integer monitor4 = new Integer(-4);

	/**
	 * Adding.
	 * @param user user
	 */
	public void add(User user) {
		synchronized (monitor3) {
			monitor3 = user.getId();
			if (!(monitor3.equals(monitor0) && monitor3.equals(monitor1) && monitor3.equals(monitor2))) {
				list.put(user.getId(), user);
			}
			monitor3 = -3;
		}
		
		
	}

	/**
	 * Updating.
	 * @param id
	 * @param amount
	 */
	public void update(int id, int amount) {
		synchronized (monitor4) {
			monitor4 = id;
			if (!(monitor4.equals(monitor0) && monitor4.equals(monitor1) && monitor4.equals(monitor2) && monitor4.equals(monitor3))) {
				list.get(id).setAmount(amount);
			}
			monitor4 = -4;
		}
	}

	/**
	 * Deleting.
	 * @param id
	 */
	public void delete(int id) {
		synchronized (monitor2) {
			monitor2 = id;
			if (!(monitor2.equals(monitor0) && monitor2.equals(monitor1))) {
				list.remove(id);
			}
			monitor2 = -2;
		}
	}

	/**
	 * Transferring.
	 * @param fromId
	 * @param toId
	 * @param amount
	 */
	public void transfer(int fromId, int toId, int amount) {
		synchronized (monitor1) {
			monitor1 = fromId;
			monitor0 = toId;
			
			getUser(fromId).subtractAmount(amount);
			getUser(toId).addAmount(amount);
		
			monitor0 = -10;
			monitor1 = -1;
		}
		
	}

	/**
	 * Printing all users or something else.
	 */
	public void print() {
		synchronized (monitor2) {
			
			for (Entry<Integer, User> entry : list.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue().getAmount());
			}
		}

	}
	
	/**
	 * Getting user by id from list.
	 * @param id
	 * @return
	 */
	private User getUser(int id) {
		return list.get(id);
	}
	
}
