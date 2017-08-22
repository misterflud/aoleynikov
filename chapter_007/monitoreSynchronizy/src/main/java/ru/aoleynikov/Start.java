package ru.aoleynikov;

/**
 * For testing program.
 * @author Anton Oleynikov
 * created on 22.08.2017
 */
public class Start {
	/**
	 * 
	 */
	static int ii;
	
	/**
	 * Storage.
	 */
	static UserStorage userStorage = new UserStorageOne();
	
	/**
	 * Start.
	 * @param args args.
	 */
	public static void main(String[] args) {
	
		
		for (int i = 0; i < 2; i++) {
			ii = i;
			Thread thread = new Thread() {
				
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						userStorage.add(new User((ii * 10 + j), 100));
						System.out.println(ii * 10 + j);
					}
				}
			};
			thread.start();
		}
		try {
			Thread.sleep(10000);
			userStorage.print();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
