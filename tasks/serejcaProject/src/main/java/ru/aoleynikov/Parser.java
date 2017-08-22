package ru.aoleynikov;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


 
/**
 * Parser for html file.
 * @author Anton Oleynikov
 * created on 22.08.2017
 */
public class Parser {
	private ArrayList<String> users = new ArrayList<>(1000);
	
	public ArrayList<String> parse(String path, StreamOut streamOut) {
		File file = new File(path);
		String id = "";
		try {
			Document document = Jsoup.parse(file, "UTF-8");
			Elements authors = document.getElementsByClass("author");
			for (Element author : authors) {
				id = author.attr("href");
				streamOut.printOut(id);
				//System.out.println(id);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		
		return users;
	}

}
