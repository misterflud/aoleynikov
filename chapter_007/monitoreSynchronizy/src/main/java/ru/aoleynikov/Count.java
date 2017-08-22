package ru.aoleynikov;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
/**
 * Count.
 * @author Anton Oleynikov
 * created on 03.08.2017
 */
@ThreadSafe
public class Count {
	/**
	 * Lock object.
	 */
	final Object lock = new Object();
	/**
	 * Saver condition.
	 */
	@GuardedBy(value = "lock")
	private int count = 0;
	

	/**
	 * Adding 1.
	 */
	public void inctement() {
		synchronized(lock) {
			count++;
		}
	}
	
	/**
	 * Getting count.
	 * @return count
	 */
	public synchronized int getCount() {
		return count;
	}
	
	
	
	/*
	//lock = this
	public synchronized void add(int i) {
		count++;
	}
	
	
	public void add2(int i) {
		synchronized (this) {
			count++;
		}
	}
	

	
	public void add3(int i) {
		synchronized (lock) {
			count++;
		}
	}
	
	
	public void add4(int i) {
		synchronized (Count.class) {
			count++;
		}
	}
	*/
}
