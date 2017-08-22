package ru.aoleynikov;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Writing to txt file.
 * @author Anton Oleynikov
 * created on 22.08.2017
 */
public class TxtOut implements StreamOut {
	
	/**
	 * Writer.
	 */
	private BufferedWriter writer;
	
	/**
	 * Constructor.
	 * @param path
	 */
	public TxtOut(String path) {
		try {
			writer = new BufferedWriter(new FileWriter(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Printing (writing).
	 */
	@Override
	public void printOut(String s) {
		try {
			writer.write(s);
			writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Closing streams.
	 */
	@Override
	public void close() throws IOException {
		writer.close();
	}

}
