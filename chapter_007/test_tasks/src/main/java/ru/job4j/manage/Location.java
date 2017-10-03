package ru.job4j.manage;

/**
 * Location if heroes.
 * @author Anton Oleynikov
 * created on 02.10.2017
 */
public class Location {
	
	/**
	 * Ox.
	 */
	public volatile int coordX;
	
	/**
	 * Oy.
	 */
	public volatile int coordY;
	
	/**
	 * Constructor.
	 * @param coordX X
	 * @param coordY Y
	 */
	public Location(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	/**
	 * Constructor.
	 */
	public Location() {
		
	}
	
	/**
	 * Gets copy.
	 * @return Location Location
	 */
	public synchronized Location getCopy() {
		return new Location(coordX, coordY);
	}
	
	/**
	 * Changes Location.
	 * @param newLocation newLocation
	 */
	public synchronized void changeLocation(Location newLocation) {
		this.coordX = newLocation.coordX;
		this.coordY = newLocation.coordY;
	}
	
	
	
	

	
	

}
