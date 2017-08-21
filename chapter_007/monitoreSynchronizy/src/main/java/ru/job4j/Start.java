package ru.aoleynikov;

public class Start {
	static int ii;
	static UserStorage userStorage = new UserStorageOne();
	
	
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
