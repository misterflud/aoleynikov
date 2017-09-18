package ru.job4j;



/**
 * Lock for more flexible synchronization.
 * @author Anton Oleynikov
 * created on 12.09.2017
 */
public class LockMashine {
	
	/**
	 * Locked or not.
	 */
	private volatile boolean lockOrNot = false;
	
	
	/**
	 * Count of threads.
	 */
	private volatile int count = 0;
	/**
	 * Locked or not.
	 */
	Thread  lockedBy = null;
	/**
	 * Counts Threads.
	 */
	int lockedCount = 0;
	
	/**
	 * Object for Lock.
	 */
	private Object lock1 = new Lock();
	
	/**
	 * Object for Lock.
	 */
	private Object lock2 = new Lock2();
	
	
	
	/**
	 * Locking.
	 */
	public synchronized void lock() {
		Thread callingThread = Thread.currentThread();
		while (lockOrNot && lockedBy != callingThread) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		lockedCount++;
		lockOrNot = true;
		lockedBy = callingThread;
	}
	

	/**
	 * Unlocking.
	 */
	public synchronized void unlock() {
		if(Thread.currentThread() == this.lockedBy){
		      lockedCount--;

		      if(lockedCount == 0){
		    	lockOrNot = false;
		        notify();
		      }
		    }
		if (lockOrNot) {
			lockOrNot = false;
			notify();
		}
	}
	
	
	
	/**
	 * Check conditions.
	 * @return condition of lock
	 */
	public boolean lockOrNot() {
		return lockOrNot;
	}
	
	/**
	 * Cyclic.
	 * @param max threads
	 */
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
	
	/**
	 * Don't use.
	 * @param milisec milisec
	 */
	public void lock(int milisec) {
		System.out.println("asd2");
		try {
			lock1.wait(milisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Class for lock's Object. 
	 * @author Anton Oleynikov
	 * created on 12.09.2017
	 */
	private static final class Lock { }
	
	/**
	 * Class for lock's Object. 
	 * @author Anton Oleynikov
	 * created on 12.09.2017
	 */
	private static final class Lock2 { }
		
	
	

}
