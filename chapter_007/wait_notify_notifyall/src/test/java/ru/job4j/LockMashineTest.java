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
		
		final CyclicBarrier barrier = new CyclicBarrier(5);
	
		Experiment experiment = new Experiment(barrier);
		
		experiment.print();
		for (int i = 1; i < 11; i++) {
			new ThreadOne(experiment, i, i).start();
		}
		try {
			ThreadOne.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		experiment.print();
	}
	
	
	private class ThreadOne extends Thread {
		
		Experiment exp;
		int process;
		int wait;
		
		public ThreadOne(Experiment exp, int wait,  int process) {
			this.exp = exp;
			this.wait = wait;
			this.process = process; 
		}
		
		@Override
		public void run() {
			try {
				//sleep(100 * wait);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			exp.doA(process);
			exp.doB(process);
			exp.doC(process);

		}
	}
}
