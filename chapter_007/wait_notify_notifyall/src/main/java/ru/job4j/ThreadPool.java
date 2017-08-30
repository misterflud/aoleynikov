package ru.job4j;

import java.io.Closeable;
import java.io.IOException;

import java.util.concurrent.ConcurrentLinkedQueue;



public class ThreadPool implements Closeable {
	
	private volatile boolean stop = false;
	
	private int cores;
	
	private int busyThreads = 0;
	
	private ConcurrentLinkedQueue<Work> works = new ConcurrentLinkedQueue<>();
	
	public ThreadPool(int cores) {
		this.cores = cores;
		new TasksPool().start();
	}
	
	public synchronized void add(Work work) {
		//System.out.println(works.size());
		works.add(work);
	}
	
	/**
	 * 
	 * @author Anton Oleynikov
	 * created on 30.08.2017
	 */
	private class TasksPool extends Thread {
		
		@Override
		public void run() {
			begin();
		}
		
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
	 * 
	 * @author Anton Oleynikov
	 * created on 30.08.2017
	 */
	
	private class WorkerThread extends Thread {
		
		
		private Work work;
		
		
		public WorkerThread(Work work) {
			this.work = work;
		}
		
		
		@Override
		public void run() {
			executeWork();
		}
		
		private void executeWork() {
			if (work != null) {
				work.execute();
			}
		}
		
	}

	@Override
	public void close() throws IOException {
		stop = true;
	}
	

}
