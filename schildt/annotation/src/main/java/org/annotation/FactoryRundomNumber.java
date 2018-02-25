package org.annotation;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * 
 * @author Anton
 *	Factory creates Random numbers and adds their in fields of object T.
 */
public class FactoryRundomNumber<T> implements Factory<T> {


	@Override
	public T getObject(T t) {
		
		Field[] field = t.getClass().getDeclaredFields();
		for (Field iter : field) {
			RandomNumberAnnotation annotation = iter.getAnnotation(RandomNumberAnnotation.class);
			if (annotation != null) {
				int min = annotation.min();
				int max = annotation.max();
				Random random = new Random();
				int r = min + random.nextInt(max - min);
				iter.setAccessible(true);
				try {
					iter.set(t, r);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return t;
	}
}
