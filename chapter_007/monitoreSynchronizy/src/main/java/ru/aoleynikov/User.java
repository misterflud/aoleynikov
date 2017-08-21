package ru.aoleynikov;

/**
 * User.
 * @author Anton Oleynikov
 * created on 03.08.2017
 */
public class User {
	
	/**
	 * Id.
	 */
	private int id;
	
	/**
	 * Amount.
	 */
	private int amount;
	
	/**
	 * Constructor.
	 * @param id id
	 * @param amount amount
	 */
	public User(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public User(int amount) {
		this.amount = amount;
	}
	/**
	 * Getter.
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Getter.
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Setter.
	 * @param id id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Setter.
	 * @param amount amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * Update.
	 * @param user User class
	 */
	public void update(User user) {
		id = user.id;
		amount = user.amount;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	/**
	 * Checking equals.
	 */
	@Override
	public boolean equals(Object user) {
		if (user instanceof User) {
			if (((User) user).id == id) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Adding amount.
	 * @param plus amount
	 */
	public void addAmount(int plus) {
		this.amount += plus; //this.amount =+ plus не работает адекватно, почему?
	}
	
	/**
	 * Subtracting from amount.
	 * @param del del
	 */
	public void subtractAmount(int del) {
		this.amount -= del;
	}
}
