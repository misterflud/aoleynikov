package ru.aoleynikov;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


 

public class Parser {
	private ArrayList<String> users = new ArrayList<>();
	
	public ArrayList<String> parse(String path) {
		File file = new File(path);
		String id = "";
		try {
			Document document = Jsoup.parse(file, "UTF-8");
			Elements authors = document.getElementsByClass("author");
			for (Element author : authors) {
				id = author.attr("href");
				
				System.out.println(id);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return users;
	}

}
