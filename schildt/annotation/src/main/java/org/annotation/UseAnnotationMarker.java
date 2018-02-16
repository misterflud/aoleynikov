package org.annotation;

import java.lang.reflect.Method;

public class UseAnnotationMarker {
	
	@AnnotationMarker
	public static void main(String[] args) {
		try {
			UseAnnotationMarker use = new UseAnnotationMarker();
			Method method = use.getClass().getMethod("main", String[].class);
			if (method.isAnnotationPresent(AnnotationMarker.class)) {
				System.out.println("в методе есть аннотация типа " +  AnnotationMarker.class);
			} else {
				System.out.println("в методе нет аннотаци типа " +  AnnotationMarker.class);
			}
		} catch (Exception e) {
			System.out.println("Что то пошло не так");
		}
	}
}
