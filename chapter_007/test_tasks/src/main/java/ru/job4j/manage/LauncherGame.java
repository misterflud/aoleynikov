package ru.job4j.manage;

import ru.job4j.communication.StreamOut;
import ru.job4j.communication.User;
import ru.job4j.heroes.Bomberman;

/**
 * Launcher.
 * @author Anton Oleynikov
 * created on 26.09.2017
 */
public class LauncherGame {
	
	private StreamOut streamOut = new StreamOut();
	
	private Board board = new Board(5, 5, streamOut);
	
	/**
	 * Bomberman.
	 */
	private Bomberman bomberman = new Bomberman(board);
	
	/**
	 * Create user.
	 */
	private User user = new User(bomberman, board.getStartLocation());
	
	private AutoUser autoUser = new AutoUser(user);
	
	/**
	 * Start program.
	 * @param args args
	 */
	public static void main(String[] args) {  //parameters
		LauncherGame launcherGame = new LauncherGame();
		launcherGame.start();
	}
	
	/**
	 * Start.
	 */
	private void start() {
		autoUser.start();
	}
	
	
}
