package ru.aoleynikov;

public class Manager {
	private String site;
	
	private Parser parser = new Parser();
	private PushingButton pushingButton = new PushingButton();
	public Manager(String site) {
		this.site = site;
	}
	
	public void parsing() {
		/*
		pushingButton.push(site);
		*/
		
		parser.parse("C://Users//oleynikov//Desktop//processing//sergProject//ВКонтакте _ Comments Widget.html");
	}
	
}
