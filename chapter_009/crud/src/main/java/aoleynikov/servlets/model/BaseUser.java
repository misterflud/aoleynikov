package aoleynikov.servlets.model;

import java.sql.Timestamp;

/**
 * Created by Anton on 02.07.2017.
 */
public abstract class BaseUser {
    /**
     * Name user.
     */
    private String name;
    /**
     * Login.
     */
    private String login;
    /**
     * Email.
     */
    private String email;
    /**
     * When created.
     */
    private Timestamp timeOfCreate;
    
    /**
     * 
     */
    private String userType;
    /**
     * 
     */
    private String password;
    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     * @param timeOfCreate when created
     * @param userType type 
     * @param password password
     */
    public BaseUser(String name, String login, String email, Timestamp timeOfCreate, String userType, String password) {
        this.setName(name);
        this.setLogin(login);
        this.setEmail(email);
        this.setTimeOfCreate(timeOfCreate);
        this.userType = userType;
        this.password = password;
    }

    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     * @param timeOfCreate when created
     */
    public BaseUser(String name, String login, String email, Timestamp timeOfCreate) {
        this.setName(name);
        this.setLogin(login);
        this.setEmail(email);
        this.setTimeOfCreate(timeOfCreate);
    }

    /**
     * Constructor.
     * @param name name
     * @param login login
     * @param email email
     */
    public BaseUser(String name, String login, String email) {
        this.setName(name);
        this.setLogin(login);
        this.setEmail(email);
        this.setTimeOfCreate(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * Constructor.
     */
    public BaseUser(){

    }

    /**
     * Constructor.
     * @param login login
     */
    public BaseUser(String login){
        this.setLogin(login);
    }
    
    public BaseUser(String login, String password) {
    	this.setLogin(login);
    	this.setPassword(password);
    }

    /**
     * Constructor.
     * @param user User
     */
    public BaseUser(User user){
        this.setName(user.getName());
        this.setLogin(user.getLogin());
        this.setEmail(user.getEmail());
        this.setTimeOfCreate(user.getTimeOfCreate());
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the timeOfCreate
	 */
	public Timestamp getTimeOfCreate() {
		return timeOfCreate;
	}

	/**
	 * @param timeOfCreate the timeOfCreate to set
	 */
	public void setTimeOfCreate(Timestamp timeOfCreate) {
		this.timeOfCreate = timeOfCreate;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}