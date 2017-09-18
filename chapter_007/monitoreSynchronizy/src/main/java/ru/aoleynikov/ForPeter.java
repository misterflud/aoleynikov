package ru.aoleynikov;

public class ForPeter {
	
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	
	int count = 0;
	 
	void increment() {
	   synchronized(lock1) {
	      count++;
	   }
	   
	}
	 
	 void decrement() {
		synchronized(lock2) {
			count--;
		}
	 }
	 
	 int get() {
		 synchronized (lock1) {
			synchronized (lock2) {
				return count;
			}
		}
		 
	 }
}
