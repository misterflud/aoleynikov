package ru.aoleynikov;
//Приостановка, возобновление и остановка потоков исполнения 311
public class SuspeпdResume {

	public static void main(String[] args) {
		New2Thread ob1 = new New2Thread("Один");
		New2Thread ob2 = new New2Thread("Двa");
		try {
			Thread.sleep(1000);
			ob1.mysuspend();
			System.out.println("Пpиocтaнoвкa потока Один");
			Thread.sleep(1000);
			ob1.myresume();
			System.out.println(" Boзoбнoвлeниe потока Один ");
			ob2.mysuspend();
			System.out.println("Пpиocтaнoвкa потока Два ");
			Thread.sleep(1000);
			ob2.myresume();
			System.out.println("Boзoбнoвлeниe потока Два");
		}
		catch (InterruptedException е) {
			System.out.println("Глaвный поток прерван");
		}
		
		//ожидать завершения потоков исполнения
		try {
			System.out.println( "Oжидaниe завершения потоков.");
			ob1.t.join();
			ob2.t.join();
		}
		catch(InterruptedException е) {
			System.out.println("Глaвный поток прерван");	
		}
		System.out.println("Глaвный поток завершен"); 
	}

}
		//Приостановка и возобновление исполнения потока современным способом
class New2Thread implements Runnable {
	String name; // имя потока исполнения
	Thread t;
	boolean suspendFlag;
	
	New2Thread(String threadname) {
		name = threadname;
		t = new Thread (this, name);
		System.out.println ("Hoвый поток : "+ t);
		suspendFlag = false;
		t.start(); // запустить поток исполнения
	}
	// Точка входа в поток исполнения
	public void run () {
		try {
			for ( int i = 15; i > 0; i--) {
				System.out.println(name + ":" + i);
				Thread.sleep(500);
				synchronized (this) {
					while (suspendFlag) {
						wait();
					}
				}
			}
		}
		catch (InterruptedException е) {
			System.out.println(name + " прерван. ");
		}
		System.out.println(name + " завершен.");
	}
	
	synchronized void mysuspend() {
		suspendFlag = true;
	}
	
	synchronized void myresume() {
		suspendFlag = false;
		notify(); 
	}	
}
		
		
		
		
		
		
		
		
		