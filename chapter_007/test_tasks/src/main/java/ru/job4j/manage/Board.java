 package ru.job4j.manage;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import ru.job4j.communication.StreamOut;
import ru.job4j.errors.CheaterException;
import ru.job4j.errors.OutOfBoardException;

/**
 * Board for game.
 * @author Anton Oleynikov
 * created on 02.10.2017
 */
public class Board {
	
	/**
	 * Sent information.
	 */
	private final StreamOut streamOut;
	
	/**
	 * Start coordination.
	 */
	private final int x;
	
	/**
	 * Start coordination.
	 */
	private final int y;
	/**
	 * Board.
	 */
	private final int[][] board;
	ReentrantLock[][] boardLock;
	
	/**
	 * Constructor.
	 * @param x x
	 * @param y y
	 * @param streamOut streamOut
	 */
	public Board(int x, int y, StreamOut streamOut) {
		this.streamOut = streamOut;
		this.board = new int[x][y];
		this.boardLock = new ReentrantLock[y][x];
		
		this.x = x;
		this.y = y;
		for (int[] i : board) {
			for (int j : i) {
				j = 0;
			}
		}
	}
	
	/**
	 * Calculate start location
	 * @return
	 */
	public synchronized Location getStartLocation() {
		
		Random random = new Random();
		int xx = random.nextInt(x - 1); //поменять
		int yy = random.nextInt(y - 1);
		Location location = new Location(xx, yy);
		markCell(location, location);
		return location;
	}
	
	/**
	 * 
	 * @param oldLocation oldLocation
	 * @param newLocation newLocation
	 * @return newLocation
	 */
	public synchronized Location changeLocation(Location oldLocation, Location newLocation) {
		
		if (newLocation.coordX > x || newLocation.coordX < 0 || newLocation.coordY > y || newLocation.coordY < 0) {
			System.out.print("No ");
			//markCell(oldLocation, oldLocation);
			return oldLocation;
		} else {
			markCell(oldLocation, newLocation);
			System.out.print("Yes ");
			return newLocation;
		}
		
	}
	
	 /**
	  * Sends board to user.
	  */
	private synchronized void sendStream() {
		streamOut.out(board);
	}
	
	/**
	 * Marks cell.
	 * @param oldLocation oldLocation
	 * @param newLocation newLocation
	 */
	private synchronized void markCell(Location oldLocation, Location newLocation) {
		//System.out.println(oldLocation.coordY + " " + oldLocation.coordX + " " + newLocation.coordY + " " + newLocation.coordX);
		board[oldLocation.coordY][oldLocation.coordX] = 0;
		board[newLocation.coordY][newLocation.coordX] = 2;
		sendStream();
	}
	
}



















