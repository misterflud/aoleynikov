package ru.job4j;



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMashine {
	
	private volatile boolean lockOrNot = false;
	
	//private volatile boolean lockSemaphore = false;
	
	
	
	private volatile int count = 0;
	private Object lock1 = new Lock();
	private Object lock2 = new Lock2();
	
	
	
	
	public synchronized void lock() {
		while (lockOrNot) { // wait невозможно использовать иначе вылазиет ошибка IllegalMonitorStateException
			
		}
		System.out.println("sssssss");
		lockOrNot = true;
	}
	

	
	public void unlock() {
		if (lockOrNot) {
			lockOrNot = false;
			//notifyAll();
		}

		
	}
	
	
	
	
	public boolean lockOrNot() {
		return lockOrNot;
	}
	
	
	public void cyclicBarrier (int max) {
		synchronized (lock1) {
			count++;
		}
		while(count != 3) {
			
		}
		synchronized (lock1) {
			count = 0;
		}
	}
	
	
	public void lock(int milisec) {
		System.out.println("asd2");
		try {
			lock1.wait(milisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private static final class Lock { }
	private static final class Lock2 { }
		
	
	

}
