package ru.job4j;

import org.junit.Test;

/**
 * Test.
 * @author Anton Oleynikov
 * created on 26.09.2017
 */
public class CacheTest {
	
	/**
	 * Cache.
	 */
	private Cache<Integer, Integer> cache = new Cache<Integer, Integer>();
	
	/**
	 * Test one.
	 */
	@Test
	public void whenThen() {
		
		for (int i = 0; i < 10; i++) {
			new ThreadOne(i).start();
		}
		
		for (int i = 0; i < 5; i++) {
			new ThreadTwo(i).start();
		}
		
		cache.update(9, -100);
		for (int i = 0; i < 10; i++) {
			System.out.println(cache.get(i));
		}
	}
	
	/**
	 * Thread for adding models.
	 * @author Anton Oleynikov
	 * created on 26.09.2017
	 */
	public class ThreadOne extends Thread {
		int i;
		
		public ThreadOne(int i) {
			this.i = i;
		}
		
		
		@Override
		public void run() {
			cache.add(i, i);
		}
	}
	
	/**
	 * Thread for updating model.
	 * @author Anton Oleynikov
	 * created on 26.09.2017
	 */
	public class ThreadTwo extends Thread {
		
		int i;
		
		public ThreadTwo(int i) {
			this.i = i;
		}
		
		@Override
		public void run() {
			cache.update(i, i * -1);
			cache.update(i + 1, i * -11);
		}
	}
}
