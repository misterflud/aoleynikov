package ru.aoleynikov;

import java.io.Closeable;

public interface StreamOut extends Closeable {
	public void printOut(String s);
}
