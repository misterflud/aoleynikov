package ru.job4j.heroes;


import ru.job4j.manage.Board;
import ru.job4j.manage.Location;

public class Bomberman implements HeroesAction {
	
	/**
	 * Board.
	 */
	private Board board;
	
	/**
	 * Constructor.
	 * @param board board
	 */
	public Bomberman(Board board) {
		this.board = board;
	}
	
	/**
	 * Moves.
	 */
	public synchronized Location move(Location oldLocation, Location newLocation) {
		System.out.println(oldLocation.coordY + " " + oldLocation.coordX + " " + newLocation.coordY + " " + newLocation.coordX);
		return board.changeLocation(oldLocation, newLocation);
	}


		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*

if (location.coordX >= x - 1) {
			location.vector[2] = 1;
			location.vector[3] = 0;
			
		} else if(location.coordX - 1 <= 0) {
			location.vector[2] = 0;
			location.vector[3] = 1;
		} else {
			location.vector[2] = 1;
			location.vector[3] = 1;
		}
		
		if (location.coordY >= y - 1) {
			location.vector[0] = 1;
			location.vector[1] = 0;
			
		} else if(location.coordY - 1 <= 0) {
			location.vector[0] = 0;
			location.vector[1] = 1;
		} else {
			location.vector[0] = 1;
			location.vector[1] = 1;
		}
		
		if (location.vector[0] == 1) {
			if (board[location.coordY][location.coordX] != 0) {
				
			}
		}
		if (location.vector[1] == 1) {
			
		}
		if (location.vector[2] == 1) {
			
		}
		if (location.vector[3] == 1) {
			
		}
	 */
}
