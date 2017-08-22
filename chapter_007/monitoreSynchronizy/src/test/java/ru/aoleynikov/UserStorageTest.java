package ru.aoleynikov;
/**
 * Tests.
 * @author Anton Oleynikov
 * created on 03.08.2017
 */

import org.junit.Test;
/**
 * Test class.
 * @author Anton Oleynikov
 * created on 22.08.2017
 */
public class UserStorageTest {
	
	/**
	 * Test.
	 * We are creating 20 threads with different actions.
	 */
	@Test
	public void whenThen() {
		UserStorage userStorage = new UserStorageOne(); 
		//UserStorage userStorage = new UserStorageTwo();
		for (int i = 0; i < 10; i++) {
			AddingTread addingTread = new AddingTread("T" + i, i, userStorage);
			addingTread.start();
		}
		for (int i = 1; i < 10; i++) {
			TransactionTread transactionTread = new TransactionTread(i, userStorage);
			transactionTread.start();
		}
		try {
			Thread.sleep(1000); //печать не потокобезопасна, поэтому используем сон
			userStorage.print();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Thread for adding user.
	 * @author Anton Oleynikov
	 * created on 07.08.2017
	 */
	class AddingTread extends Thread {
		private String name;
		private int count;
		UserStorage userStorage;
		
		public AddingTread(String name, int count, UserStorage userStorage) {
			this.name = name;
			this.count = count;
			this.userStorage = userStorage;
		}
				
		@Override
		public void run() {
			for (int j = 0; j < 10; j++) {
				userStorage.add(new User((count * 10 + j), 100));
				//System.out.println(name + " " + count);
			}
		}
	}
	
	/**
	 * Thread for transaction.
	 * @author Anton Oleynikov
	 * created on 22.08.2017
	 */
	class TransactionTread extends Thread {
		private String name;
		private int count;
		UserStorage userStorage;
		
		public TransactionTread(int count, UserStorage userStorage) {
			this.name = name;
			this.count = count;
			this.userStorage = userStorage;
		}
				
		@Override
		public void run() {
			userStorage.transfer(0, count, 3);
				//System.out.println(name + " " + count);
		}
	}
}
