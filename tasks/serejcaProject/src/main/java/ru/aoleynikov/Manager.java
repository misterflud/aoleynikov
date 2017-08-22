package ru.aoleynikov;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Managing all program logic.
 * @author Anton Oleynikov
 * created on 22.08.2017
 */
public class Manager {
	/**
	 * Path to interned page.
	 */
	private String site;
	
	/**
	 * Path to html file instead site.
	 */
	private String htmlFile;
	
	/**
	 * Path to result file.
	 */
	private String resultFile;

	/**
	 * Parser html file.
	 */
	private Parser parser = new Parser();
	
	/**
	 * Creating html file from site.
	 */
	private PushingButton pushingButton = new PushingButton();
	
	/**
	 * Constructor.
	 */
	public Manager() {
		getProperties();
	}
	
	/**
	 * Start program.
	 */
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
	
	/**
	 * Getting parameters from properties.
	 */
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
