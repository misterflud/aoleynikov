package ru.job4j.manage;

import java.util.Random;

import ru.job4j.communication.User;
/**
 * Manager of Bombreman.
 * @author Anton Oleynikov
 * created on 02.10.2017
 */
public class AutoUser extends Thread {
	
	/**
	 * API for manages of Heroes.
	 */
	private User user;
	
	/**
	 * Constructor.
	 * @param user user
	 */
	public AutoUser(User user) {
		this.user = user;
	}
	
	/**
	 * Run.
	 */
	@Override
	public void run() {
		Random random = new Random();
		int i = 0;
		while (true) {
			try {
				sleep(1000);
				i= random.nextInt(4);
				switch (i) {
				case 0:
					user.moveDown();
					break;
				case 1:
					user.moveUp();
					break;
				case 2:
					user.moveLeft();
					break;
				case 3:
					user.moveRight();
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

}
