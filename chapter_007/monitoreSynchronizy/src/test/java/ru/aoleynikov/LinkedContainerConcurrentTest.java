package ru.aoleynikov;

import org.junit.Test;


public class LinkedContainerConcurrentTest {
	
	private LinkedContainerConcurrent<Integer> container = new LinkedContainerConcurrent<>();
	@Test
	public void whenThen() {
		
		for (int i = 0; i < 100; i++) {
			new ThreadOne(i, i).start();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 100; i++) {
			System.out.println(container.get(i));
		}
	}
	
	public class ThreadOne extends Thread {
		
		
		private int i;
		
		private int number;
		
		
		public ThreadOne(int i, int number) {
			this.i = i;
			this.number = number;
		}
		
		@Override
		public void run() {
			container.add(number);
		}
	}
}
