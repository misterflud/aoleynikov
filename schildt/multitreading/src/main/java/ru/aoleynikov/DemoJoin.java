package ru.aoleynikov;

public class DemoJoin {

	public static void main(String[] args) {
		NewThread о1 = new NewThread ( "Один" );
		NewThread оЬ2 new NewThread ( "Двa " );
		NewThread оЬЗ new NewThread ( "Tpи" );
		System . out . println ( "Пoтoк Один запущен : "
		+ oЫ .t. i sAlive ( )};
		System.out . println ( " Пoтoк Два запущен : "
		+ ob2 .t. i sAli ve ( });
		System.out . println ( " Пoтoк Три запущен : "
		+ obЗ .t. i sAl i ve ( ));
		// ожидать завершения потоков исполнения
		try {
			System.out.println ( "Oжидaниe завершения потоков . " );
			оЫ . t . j oin ( ) ;
			оЬ2 . t . j oin ( ) ;
			оЬЗ . t . j oin () ;
		}
		catch ( InterruptedException е} {
		System . out . println ( " Глaвный поток прерван " );
		System.out . println ( "Пoтoк Один запущен : "
		+ oЫ .t. i s.Alive() };
		System . out . println ( " Пoтoк Два запущен : "
		+ ob2 .t. i sAlive() );
		System.out . println ( "Пoтoк Три запущен : "
		+ obЗ .t. i sAlive ( ) ) ;
		System.out.println ("Глaвный поток завершен . "} ;

	}
	//11 Применить метод j oin() , ч тобы ожидать завершения потоков исполнения
	class NewThread implements Ruппаblе {
		Striпg паmе; // имя потока исполнения
		Thread t;
		
		NewThread (Striпg threadname) {
			
		}
		name = threadname; 
		t = new Thread (this , name ) ;
		System.out . println ("Hoвый поток : "+ t ) ;
		t.start(} ; // запустить поток исполнения
		11 Точка входа в поток исполнения
		public void run() {
			try {
				for (int i = 5; i > 0; i--) {
					System.out.println (name + "· "+ i );
				}
				Thread.sleep (1000);
			catch (InterruptedException е) {
				System.out.println(name + " прерван . ");
				
				}
			System.out.println(name + " завершен . ");
			}
		}
	}

}
