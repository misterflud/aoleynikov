package ru.job4j.model;

public class AnonUser extends BaseUser {
	
	public AnonUser(String name, String login, String email, String password, Role role) {
		super(name, login, email, password, role);
	}
	
	public AnonUser(String name, String login, String email, Role role) {
		super(name, login, email, role);
	}
	
	public AnonUser(String name, String login, String email) {
		super(name, login, email);
	}
	
	public AnonUser(String login, String password) {
		super(login, password);
	}
	
	public AnonUser(String login) {
		super(login);
	}
}
