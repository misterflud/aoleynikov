package aoleynikov.servlets.model;



public abstract class Role {
	
	private int id;
	
	private String name;
	


	
	public Role(int id, String name) {
		this.name = name;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object role) {
		if (! (role instanceof Role)) {
			return false;
		}
		Role role2 = (Role) role;
		if (role2.id == this.id) {
			return true;
		}
		return false;
	}
}
