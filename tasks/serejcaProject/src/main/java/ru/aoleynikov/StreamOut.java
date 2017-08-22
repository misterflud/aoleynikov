package ru.aoleynikov;

import java.io.Closeable;

/**
 * Interface with standard method.
 * @author Anton Oleynikov
 * created on 22.08.2017
 */
public interface StreamOut extends Closeable {
	/**
	 * Printing in file, console etc.
	 * @param s s
	 */
	public void printOut(String s);
}
