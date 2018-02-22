package ru.job4j.storageSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStorage {
	@Autowired
	private  Storage storage;
	
	private  int x = 0;
	
	public UserStorage(Storage storage) {
		this.storage = storage;
		System.out.println(this.storage);
	}
	
	public UserStorage() {
		System.out.println(x);
		x++;
	}
	
	@Autowired
	public void set(Storage storage) {
		this.storage = storage;
	}
	
	
	public void add(User user) {
		this.storage.add(user);
	}
	
	
	

}
