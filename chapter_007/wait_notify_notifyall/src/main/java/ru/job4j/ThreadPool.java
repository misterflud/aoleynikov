package ru.job4j;

import java.io.Closeable;
import java.io.IOException;

import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * ThreadPool.
 * @author Anton Oleynikov
 * created on 30.08.2017
 */
public class ThreadPool implements Closeable {
	
	/**
	 * When we want to stop the ThreadPool. 
	 */
	private volatile boolean stop = false;
	
	/**
	 * Cores of computer.
	 */
	private int cores;
	
	/**
	 * How much worker  threads.
	 */
	private volatile int busyThreads = 0;
	
	/**
	 * Queue of work tasks.
	 */
	private ConcurrentLinkedQueue<Work> works = new ConcurrentLinkedQueue<>();
	
	/**
	 * Constructor.
	 * @param cores cores
	 */
	public ThreadPool(int cores) {
		this.cores = cores;
		new TasksPool().start();
	}
	
	/**
	 * Add work.
	 * @param work work
	 */
	public synchronized void add(Work work) {
		//System.out.println(works.size());
		works.add(work);
	}
	
	/**
	 * Manages the WorkerThread.
	 * @author Anton Oleynikov
	 * created on 30.08.2017
	 */
	private class TasksPool extends Thread {
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			begin();
		}
		
		/**
		 * Begins managing.
		 */
		private void begin() {
			//System.out.println("sdfs");
			while (!stop || works.size() != 0) { //!stop && works.size() != 0 true
				if (works.size() != 0 && busyThreads < cores) {
					//System.out.println("sdfs");
					new WorkerThread(works.poll()).start();
				} else {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * Executes the work.
	 * @author Anton Oleynikov
	 * created on 30.08.2017
	 */
	
	private class WorkerThread extends Thread {
		
		/**
		 * Work.
		 */
		private Work work;
		
		
		/**
		 * Constructor.
		 * @param work
		 */
		public WorkerThread(Work work) {
			this.work = work;
		}
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			executeWork();
		}
		
		/**
		 * Executes.
		 */
		private void executeWork() {
			busyThreads++;
			if (work != null) {
				System.out.print("Worker Tread № " + busyThreads + " ");
				work.execute();
			}
			busyThreads--;
		}
		
	}

	/**
	 * Stop program (cycle in the TasksPool)
	 */
	@Override
	public void close() throws IOException {
		stop = true;
	}
	

}
