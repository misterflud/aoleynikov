package ru.aoleynikov;

import org.junit.Test;

/**
 * 
 * @author Anton Oleynikov.
 * created on 26.09.2017
 */
public class ContainerConcurrentTest {
	
	/**
	 * ArrayList.
	 */
	private ContainerConcurrent<Integer> container = new ContainerConcurrent<>();
	
	/**
	 * Test.
	 */
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
	
	/**
	 * Thread.
	 * @author Anton Oleynikov
	 * created on 26.09.2017
	 */
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
