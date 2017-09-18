package ru.job4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Experiment {
	
	//Lock lock = new ReentrantLock();
	LockMashine lock = new LockMashine();
	public static void main(String[] args) {
		
		new Experiment().start();

	}
	
	public void start() {
		for (int i = 0; i < 10; i++) {
			new Th().start();
		}
	}
	
	private synchronized void one() {
		System.out.println("1");
		two();
	}
	
	private synchronized void two() {
		System.out.println("2");
	}
	
	private void oneOne() {
		lock.lock();
		System.out.println("1");
		twoTwo();
		lock.unlock();
	}
	
	private void twoTwo() {
		lock.lock();
		System.out.println("2");
		lock.unlock();
	}
	 class Th extends Thread {
		@Override
		public void run() {
			//one();
			oneOne();
		}
	}
 }
