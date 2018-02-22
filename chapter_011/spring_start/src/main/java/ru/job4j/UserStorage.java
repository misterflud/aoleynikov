package ru.job4j;

public class UserStorage {
	
	private final Storage storage;
	
	public UserStorage(Storage storage) {
		this.storage = storage;
	}
	
	public void add(User user) {
		this.storage.add(user);
	}
	
	
	

}
