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
	private Cache<Integer, Model> cache = new Cache<Integer, Model>();
	
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cache.update(9, new Model<Integer>(100, 5));
		for (int i = 0; i < 10; i++) {
			System.out.println(cache.get(i).v);
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
			//System.out.println("bbbb");
			cache.add(i, new Model<Integer>(i));
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
			//System.out.println("aaaa");
			cache.update(i, new Model<Integer>(i * -1, 2));
			
			cache.update(i + 1, new Model<Integer>(i + 11, 3));
		}
	}
}
