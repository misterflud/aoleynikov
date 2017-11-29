package aoleynikov.servlets.model;

public class AnonUser extends BaseUser {
	
	public AnonUser(String login, String password) {
		super(login, password);
	}
	
	public AnonUser(String login) {
		super(login);
	}
}
