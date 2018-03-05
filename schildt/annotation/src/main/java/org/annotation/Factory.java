package org.annotation;

/**
 * Declaration of main method for Factory.
 * 
 * @param <T>
 */
public interface Factory<T>
{
	T getObject(T t);
}
