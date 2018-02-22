package ru.job4j;

public class StorageMemory implements Storage {

	@Override
	public void add(User user) {
		System.out.println("Store to memory");
	}

}
