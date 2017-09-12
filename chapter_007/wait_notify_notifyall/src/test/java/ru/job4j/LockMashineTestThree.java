package ru.job4j;


import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

/**
 * Test class
 * @author Anton Oleynikov
 * created on 12.09.2017
 */
public class LockMashineTestThree {
	
	/**
	 * My realization of Lock API Barrier.
	 */
	private LockMashine lockMashine = new LockMashine();
	
	/**
	 * Concurrent Barrier API.
	 */
	private CyclicBarrier barrier = new CyclicBarrier(3);
	
	/**
	 * Test.
	 */
	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			new ThreadThree(i).start();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}
	
	/**
	 * Print parameters.
	 * @param a a
	 */
	private void print(int a) {
		try {
			//barrier.await();
			lockMashine.cyclicBarrier(3);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}
	}

	
	/**
	 * Thread.
	 * @author Anton Oleynikov
	 * created on 12.09.2017
	 */
	class ThreadThree extends Thread {
		
		private int j;
		
		public ThreadThree(int j) {
			this.j = j;
		}
		@Override
		public void run() {
			print(j);
		}
	}
}
