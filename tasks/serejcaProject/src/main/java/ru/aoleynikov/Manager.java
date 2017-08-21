package ru.aoleynikov;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Manager {
	/**
	 * 
	 */
	private String site;
	
	/**
	 * 
	 */
	private String htmlFile;
	
	/**
	 * 
	 */
	private String resultFile;
	

	
	private Parser parser = new Parser();
	private PushingButton pushingButton = new PushingButton();
	/**
	 * Constructor.
	 */
	public Manager() {
		getProperties();
	}
	
	public void parsing() {
		/*
		pushingButton.push(site);
		*/
		try (TxtOut txtOut = new TxtOut(resultFile)) {
			ArrayList<String> users = parser.parse(htmlFile, txtOut);
			for (String iter : users) {
				System.out.println(iter);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void getProperties() {
		Properties prop = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			
			prop.load(input);
			
			htmlFile = prop.getProperty("htmlFile");
			
			resultFile = prop.getProperty("resultFile");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
