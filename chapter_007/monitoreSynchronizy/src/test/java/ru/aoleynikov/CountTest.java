package ru.aoleynikov;

import org.junit.Test;
/**
 * Test class.
 * @author Anton Oleynikov
 * created on 03.08.2017
 */
public class CountTest {
	/**
	 * Class is tested.
	 */
	private Count count = new Count();
	/**
	 * Test.
	 */
	@Test
	public void whenThenOne() {
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					count.inctement();
					System.out.println(String.format("%s %s", "One", count.getCount()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					count.inctement();
					System.out.println(String.format("%s %s", "Two", count.getCount()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(String.format("%s %s", "Three", count.getCount()));
	}
	
}
