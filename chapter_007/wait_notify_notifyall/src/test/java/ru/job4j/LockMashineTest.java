package ru.job4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;


/**
 * For Experiment. Don't use for test.
 * @author Anton Oleynikov
 * created on 12.09.2017
 */
public class LockMashineTest {
	
	
	private Lock lock = new ReentrantLock();
	
	

	
	
	@Test
	public void whenThenOne() {
		

	}
	
	
	private class ThreadOne extends Thread {

		@Override
		public void run() {

		}
	}
}
