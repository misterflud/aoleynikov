package ru.aoleynikov;

public class DemoJoin {

	public static void main(String[] args) {  
		NewThread ob1 = new NewThread("Один ");
		NewThread ob2 = new NewThread("Двa ");
		NewThread obЗ = new NewThread("Tpи ");
		
		System.out.println ("Пoтoк Один запущен : " + ob1.t.isAlive());
		System.out.println ("Пoтoк Два запущен : " + ob2.t.isAlive());
		System.out.println ("Пoтoк Три запущен : " + obЗ.t.isAlive());
		// ожидать завершения потоков исполнения
		try {
			System.out.println ("Oжидaниe завершения потоков . ");
			ob1.t.join();
			ob2.t.join();
			obЗ.t.join();
		}
		catch (InterruptedException e) {
			System.out.println ("Глaвный поток прерван ");
			System.out.println ("Пoтoк Один запущен : " + ob1.t.isAlive());
			System.out.println ("Пoтoк Два запущен : " + ob2.t.isAlive());
			System.out.println ("Пoтoк Три запущен : " + obЗ.t.isAlive());
			System.out.println ("Глaвный поток завершен :");
		}

	}
	// Применить метод join() , чтобы ожидать завершения потоков исполнения
}
	class NewThread implements Runnable {
		String name; // имя потока исполнения
		Thread t;
		
		public NewThread (String threadname) {
			name = threadname;
			t = new Thread(this, name);
			System.out.println ("Hoвый поток : " + t ) ;
			t.start(); // запустить поток исполнения 
		}
		

		public void run() { // Точка входа в поток исполнения
			try {
				for (int i = 5; i > 0; i--) {
					System.out.println (name + ": "+ i);
					Thread.sleep (1000);
				}
			}	
			catch (InterruptedException е) {
				System.out.println(name + " прерван.");	
			}
			System.out.println(name + " завершен.");
		}
	}