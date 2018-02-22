package ru.job4j.storageSpring;

import org.springframework.stereotype.Component;


@Component
public class StorageMemory implements Storage {
	
	public void add(User user) {
		System.out.println("Store to memory");
	}

}
