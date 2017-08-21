package ru.aoleynikov;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class StartFileFinder {

	public static void main(String[] args) {
		ArrayList<String> exts = new ArrayList<>();
		//exts.add("xls");
		exts.add("xlsx");
		exts.add("xls");

		//exts.add("txt");
		ParallerSearch parallerSearch = new ParallerSearch("C://Users//oleynikov//Desktop//1С", "877523U000", exts);
		ArrayList<String> result = parallerSearch.start();
		//System.out.println("ssssssssssssssssssssssssssssss" + result.size());
		for (String iter : result) {
			System.out.println(iter);
		}
	}

}
