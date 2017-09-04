package ru.job4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMashine {
	
	
	private Experiment experiment = new Experiment();
	private final CyclicBarrier barrier = new CyclicBarrier(5);
	
	public static void main(String[] args) {
		LockMashine lockMashine = new LockMashine();
		lockMashine.start();
	}
	
	private void start() {
		experiment.print();
		for (int i = 1; i < 11; i++) {
			new ThreadOne(experiment, i, i).start();
		}
		try {
			ThreadOne.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		experiment.print();
	}
	
	
	
	private class ThreadOne extends Thread {
		
		Experiment exp;
		int add;
		int wait;
		
		public ThreadOne(Experiment exp, int wait,  int add) {
			this.exp = exp;
			this.wait = wait;
			this.add = add; 
		}
		
		@Override
		public void run() {
			try {
				//sleep(100 * wait);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			exp.doA(add);
			exp.doB(add);
			exp.doC(add);

		}
		
	}
	
	class Experiment {
		int a = 2;
		
		int b = 2;
		
		int c = 2;
		
		public void doA(int i) {
			if (a % 2 == 0) {
				a = a + i;
			} else {
				a = a * i;
			}
		}
		
		
		public synchronized void doB(int i) {
			if (b % 2 == 0) {
				b = b + i;
			} else {
				b = b * i;
			}
			
		}
		
		public void doC(int i) {
			try {
				barrier.await();
				if (c % 2 == 0) {
					c = c + i;
				} else {
					c = c * i;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			/*
			Lock lock = new ReentrantLock();
			try {
				lock.lock();
				if (c % 2 == 0) {
					c = c + i;
				} else {
					c = c * i;
				}
				
			} finally {
				lock.unlock();
			}
			*/
		}
		
		
		
		public void print() {
			System.out.println(String.format("%s %s %s", a, b, c));
			
		}
		
	}
}
