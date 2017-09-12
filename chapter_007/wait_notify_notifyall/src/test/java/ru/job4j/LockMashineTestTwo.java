package ru.job4j;



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;


/**
 * Test class
 * @author Anton Oleynikov
 * created on 12.09.2017
 */
public class LockMashineTestTwo {
	
	/**
	 * My realization of Lock API.
	 */
	private LockMashine lockMashine = new LockMashine();
	
	/**
	 * Concurrent Lock API.
	 */
	private Lock lock = new ReentrantLock();
	
	/**
	 * Test.
	 */
	@Test
	public void test() {
		Thread t1 = new ThreadTwo(1);
		Thread t2 = new ThreadTwo(10);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Print parameters.
	 * @param a a
	 */
	private void print(int a) {
		try {
			//lock.lock();    
			lockMashine.lock();
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock.unlock();
			lockMashine.unlock();
		}
	}
	
	/**
	 * Thread.
	 * @author Anton Oleynikov
	 * created on 12.09.2017
	 */
	class ThreadTwo extends Thread {
		
		private int j;
		
		public ThreadTwo(int j) {
			this.j = j;
		}
		
		@Override
		public void run() {
			for (int i = 1; i < 100; i++) {
				try {
					if (i == 2) {
						//this.sleep(100);
					}
					this.sleep(1);
				} catch (InterruptedException e) {
					System.out.println("asdad");
				}
				print(i * j);
			}
		}
	}
}
