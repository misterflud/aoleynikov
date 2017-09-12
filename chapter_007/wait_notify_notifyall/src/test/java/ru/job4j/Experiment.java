package ru.job4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Experiment {
	int a = 2;
	
	int b = 2;
	
	int c = 2;
	
	CyclicBarrier barrier;
	
	public Experiment(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
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
