package ru.aoleynikov;

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
		ParallerSearch parallerSearch = new ParallerSearch("C://Users//oleynikov//Desktop//1С", "97133D1000", exts);
		CopyOnWriteArrayList<String> result = parallerSearch.start();
		System.out.println("ssssssssssssssssssssssssssssss" + result.size());
		for (String iter : result) {
			System.out.println(iter);
		}
	}

}