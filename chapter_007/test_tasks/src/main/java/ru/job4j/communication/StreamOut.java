package ru.job4j.communication;

public class StreamOut {
	
	public synchronized void out(int[][] board) {
		
		for (int[] i : board) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}

}
