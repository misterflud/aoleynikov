package ru.job4j;



import java.io.IOException;

import org.junit.Test;


public class ThreadPoolTest {
	
	@Test
	public void whenThen() {
		System.out.println("S");
		
		try (ThreadPool threadPool = new ThreadPool(4)) {
			for (int i = 0; i < 30; i++) {
				if (i % 2 == 0) {
					threadPool.add(new WorkOne(Integer.toString(i)));
				} else {
					threadPool.add(new WorkTwo(Integer.toString(i)));
				}
				
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
			
		EternityThread eternityThread = new EternityThread();
		eternityThread.start();
		try {
			eternityThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class WorkOne implements Work {
		
		private String name;
		
		public WorkOne(String name) {
			this.name = name;
		}

		@Override
		public void execute() {
			for (int i = 0; i < 100000; i++);
			System.out.println("One " + name);
		}
		
	}
	
	private class WorkTwo implements Work {
		
		private String name;
		
		public WorkTwo(String name) {
			this.name = name;
		}

		@Override
		public void execute() {
			for (int i = 0; i < 150000; i++);
			System.out.println("Two " + name);
		}
		
	}

}
