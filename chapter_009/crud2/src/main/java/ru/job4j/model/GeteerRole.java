package ru.job4j.model;

public class GeteerRole {
	
	public Role getRole(int id) {
		if (id == 1) {
			return new AdminRole();
		} else {
			return new UserRole();
		}
	}

}
