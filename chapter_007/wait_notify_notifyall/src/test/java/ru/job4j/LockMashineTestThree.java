package ru.job4j;


import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class LockMashineTestThree {
	
	private LockMashine lockMashine = new LockMashine();
	
	private CyclicBarrier barrier = new CyclicBarrier(3);
	
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
