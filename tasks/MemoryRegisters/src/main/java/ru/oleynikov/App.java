/**
 * 
 */
package ru.oleynikov;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Anton Oleynikov
 * created on 28 февр. 2018 г.
 */
public class App {
	
	
	public static void main(String[] str) {
		App app = new App();
		try {
			app.method();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void method() throws Exception {
//		Object a = new Cat(1);
//		String a = "adasd";
//		Object b =  a;
//		Object z = (Object) "ru.oleynikov.App$Cat@70dea4e";
//		System.out.println(a);
//		System.out.println(b);
//		
//		Cat zCat = (Cat) z;
//		System.out.println(a.toString());
//		System.out.println(b.toString());
		Cat a;
		try (FileOutputStream fos2 = new FileOutputStream("C:/Users/user/Desktop/temp2.out"); ObjectOutputStream oos2 = new ObjectOutputStream(fos2)) {
			a = new Cat(1);
			Object c = new Object();
			oos2.writeObject(c);
		}
		try (FileOutputStream fos = new FileOutputStream("C:/Users/user/Desktop/temp1.out"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				
			a = new Cat(2);
			 oos.writeObject(a);
			HashMap<String, Integer> map = new HashMap<>();
			
			Object b = new Cat(1);
			 
//			for (int i = 0; i < 2; i++) {
//				
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				 a = new Cat(i);
//				 if (i == 0) {
//					 oos.writeObject(a);
//				 } else {
//					 oos2.writeObject(a);
//				 }
//				 
//				 
//				 oos2.writeObject("ru.oleynikov.App$Cat@372f7a8d");
//				 map.put(a.toString(), 1);
//				 System.out.println(a.toString());
//				if (b.toString().equals(a.toString())) {
//					System.out.println("          " + a);
//				}
//				
//				if ("ru.oleynikov.App$Cat@372f7a8d".equals(a.toString())) {
//					System.out.println( a);
//				}
//				a = null;
//				
//			}
//			System.out.println(map.size());
		}
	}
	
}
