package ru.aoleynikov;

public class PC {
	public static void main (String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println( "Для остановки нажмите Ctrl-C.") ; 
	}
}

class Q {
	int n;
	boolean valueSet = false;
	
	synchronized int get() {
		while(!valueSet) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(" Пoлyчeнo : " + n);
		valueSet = false;
		notify();
		
		return n;
	}
	
	
	synchronized void put ( int n) {
		while(valueSet) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
			this.n = n;
			valueSet = true;
			System.out.println(" Oтпpaвлeнo : "+ n);
			notify();
		
	}
}
		
class Producer implements Runnable {
	Q q;
	Producer(Q q) {
		this.q = q;
		new Thread(this, " Поставщик ").start();
	}
	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
		}
	}	
}

class Consumer implements Runnable {
	Q q;
	Consumer (Q q) {
		this.q = q;
		new Thread(this, " Потребитель ").start();
	}
	
	public void run() {
		while (true) {
			q.get(); 
		}
	}
}

		