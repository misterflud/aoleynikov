package ru.job4j;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserStorageTest {

	@Test
	public void whenAddUserToStorageShouldSafeIt() {
		StorageMemory memory = new StorageMemory();
		UserStorage storage = new UserStorage(memory);
		storage.add(new User());
	}

}
