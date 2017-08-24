package ru.job4j;

/**
 * Producer Customer.
 * @author Anton Oleynikov
 * created on 24.08.2017
 */
public class ProducerCustomer {
	/**
	 * Monitore.
	 */
	private final Object lock = new Object();
	
	/**
	 * News
	 */
	private int news = 0;
	
	/**
	 * Has new news or not.
	 */
	private boolean hasNewData = false;
	
	/**
	 * Adding news.
	 */
	public void addNews() {
		synchronized(lock) {
			
			while(hasNewData) { //false
				try { 
					lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			news++;
			hasNewData = true;
			System.out.println(String.format("ThreadWriterProducer %s", news));
			lock.notify();
		}
	}
	
	/**
	 * Getting news.
	 */
	public void getNews() { //true
		synchronized(lock) {
			while(!hasNewData) {
				try { 
					lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			hasNewData = false;
			System.out.println(String.format("ThreadReaderCustomer %s", news));
			lock.notify();
		}
	}

	/**
	 * Start program.
	 * @param args args
	 */
	public static void main(String[] args) {
		ProducerCustomer pc = new ProducerCustomer();
		System.out.println("start");
		
		/**
		 * Reader class.
		 */
		Thread reader = new Thread() {
			
			@Override
			public void run() {
				while (pc.news != 10) {
					pc.getNews();
				}
			}
		};
		
		/**
		 * Writer class.
		 */
		Thread writer = new Thread() {
			
			@Override
			public void run() {
				while (pc.news != 10) {
					pc.addNews();
				}
			}
		};
		
		writer.start();
		reader.start();

	}

}
