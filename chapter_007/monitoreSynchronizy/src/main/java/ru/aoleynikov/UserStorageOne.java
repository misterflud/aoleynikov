package ru.aoleynikov;

import net.jcip.annotations.ThreadSafe;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Storage on ConcurrentMap.
 * @ThreadSafe
 * @author Anton Oleynikov
 * created on 03.08.2017
 */

@ThreadSafe
public class UserStorageOne implements UserStorage {
	
	/**
	 * List of Users.
	 */
	private static ConcurrentHashMap<Integer, User> list = new ConcurrentHashMap<Integer, User>(1000);
	//static CopyOnWriteArrayList<User> list = new CopyOnWriteArrayList();
	
	//ArrayList<User> list2 = new ArrayList<User>();
	
	/**
	 * Adding.
	 * @param user user
	 */
	public void add(User user) {
		list.put(user.getId(), user);
	}
	
	/**
	 * Updating.
	 * @param id
	 * @param amount
	 */
	public void update(int id, int amount) {
		list.get(id).setAmount(amount);;
	}
	
	/**
	 * Deleting.
	 * @param id
	 */
	public void delete(int id) {
		list.remove(id);
	}

	/**
	 * Transferring.
	 * @param fromId
	 * @param toId
	 * @param amount
	 */
	public void transfer(int fromId, int toId, int amount) {
		if (haveUser(fromId) && haveUser(toId)) {
			getUser(fromId).subtractAmount(amount);
			getUser(toId).addAmount(amount);
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
	

	/**
	 * Printing all users or something else.
	 */
	public void print() {
		for (Entry<Integer, User> entry : list.entrySet()) {
		    System.out.println(entry.getKey() + " " + entry.getValue().getAmount());
		}
	}
	
	/**
	 * Checking user in list.
	 * @param id id
	 * @return true or false
	 */
	private boolean haveUser(int id) {
		if (list.containsKey(id)) {
			return true;
		} else {
			return false;
		}
	}
}
