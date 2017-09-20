package ru.aoleynikov;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * Start.
 * @author Anton Oleynikov
 * created on 23.08.2017
 */
public class StartFileFinder {

	/**
	 * Start program.
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> exts = new ArrayList<>();
		//exts.add("xls");
		exts.add("xlsx"); // расширения
		exts.add("xls");

		//exts.add("txt");
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Write name of file:");
			ParallerSearch parallerSearch = new ParallerSearch("C://Users//oleynikov//Desktop//1С", reader.readLine(), exts);
			CopyOnWriteArrayList<String> result = parallerSearch.start();
			System.out.println("ssssssssssssssssssssssssssssss" + result.size());
			for (String iter : result) {
				System.out.println(iter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}