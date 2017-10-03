package ru.job4j.communication;

import ru.job4j.heroes.HeroesAction;
import ru.job4j.manage.Location;

/**
 * API for manages of heroes.
 * @author Anton Oleynikov
 * created on 02.10.2017
 */
public class User implements UserAction {
	
	/**
	 * Action of heroes.
	 */
	private volatile HeroesAction heroes;
	
	/**
	 * Old location.
	 */
	private volatile Location oldLocation;
	
	/**
	 * Temporary.
	 */
	private volatile Location bufferLocation = new Location();
	
	/**
	 * Constructor.
	 * @param heroes heroes
	 * @param location location
	 */
	public User(HeroesAction heroes, Location location) {
		this.heroes = heroes;
		this.oldLocation = location;
	}
	
	/**
	 * Moves to up.
	 */
	@Override
	public synchronized void moveUp() {
		System.out.print("up ");
		bufferLocation = oldLocation.getCopy();
		bufferLocation.coordY -= 1; 
		oldLocation = heroes.move(oldLocation, bufferLocation);
	}

	/**
	 * Moves to down.
	 */
	@Override
	public synchronized void moveDown() {
		System.out.print("down ");
		bufferLocation = oldLocation.getCopy();
		bufferLocation.coordY += 1;
		oldLocation = heroes.move(oldLocation, bufferLocation);
	}

	/**
	 * Moves to left.
	 */
	@Override
	public synchronized void moveLeft() {
		System.out.print("left ");
		bufferLocation = oldLocation.getCopy();
		bufferLocation.coordX -= 1;
		oldLocation = heroes.move(oldLocation, bufferLocation);
	}

	/**
	 * Moves to right.
	 */
	@Override
	public synchronized void moveRight() {
		System.out.print("right ");
		bufferLocation = oldLocation.getCopy();
		bufferLocation.coordX += 1;
		oldLocation = heroes.move(oldLocation, bufferLocation);
	}
	
	
	
	
}
