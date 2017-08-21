package ru.aoleynikov;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TxtOut implements StreamOut {
	
	private BufferedWriter writer;
	
	
	public TxtOut(String path) {
		try {
			writer = new BufferedWriter(new FileWriter(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printOut(String s) {
		try {
			writer.write(s);
			writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

}
