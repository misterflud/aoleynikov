package org.annotation;

public class EnumDemo {

	public static void main(String[] args) {
		Apple ap = Apple.GoldenDel;
		// вывести значение перечислимого типа
		System.out.println( " Знaчeниe ар : " + ap) ;
		System.out.println();
		ap = Apple.GoldenDel;
		// сравнить два значения перечислимого типа
		if (ap == Apple.GoldenDel)
			System.out.println ( "Пepeмeннaя ар содержит GoldenDel . \n " ) ;
		// применить перечисление для управления оператором switch
		switch(ap) {
			case Jonathan :
				System.out.println ("Copт Jonathan красный.");
				break;
			case GoldenDel:
				System.out.println ("Copт Golden Delicious желтый.");
				break;
			case RedDel:
				System.out .println ("Copт Red Delicious красный . ");
				break;
			case Winesap:
				System.out.println ("Copт Wine s ap красный.");
				break;
			case Cortland:
				System.out.println ("Copт Cortland красный.");
				break; 
		}
		
		System.out.println("--------------------------------");
		
		
		for (Apple a : Apple.values()) {
			System.out.println(a.name());
		}
		System.out.println("--------------------------------");
		System.out.println(Apple.valueOf("Winesap"));
		
		System.out.println("--------------------------------");
		for (Apple a : Apple.values()) {
			System.out.println(a.name() + "  " + a.price);
		}
	}
}
	

