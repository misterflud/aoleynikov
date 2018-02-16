package org.annotation;

import java.lang.reflect.Method;

public class UseMyAnno {
	@MyAnno (str = "Anno", val = 5)
	public static void main(String[] args) {
		UseMyAnno useMyAnno = new UseMyAnno();
		try {
			Class<?> class1 = useMyAnno.getClass();
			Method methodMain = class1.getDeclaredMethod("main", String[].class);
			MyAnno myAnno = methodMain.getAnnotation(MyAnno.class);
			System.out.println(myAnno.str() + " " + myAnno.val());
		} catch (Exception e) {
			System.out.println("Чего-то нет");
		}
	}
}
