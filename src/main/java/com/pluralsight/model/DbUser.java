package com.pluralsight.model;

public class DbUser {

	/**
	 * The username
	 */
	private String username;

	/**
	 * The password as an MD5 value
	 */
	private String password;

	/**
	 * Access level of the user. 1 = Admin user 2 = Regular user
	 */
	private Integer access;

	/**
	 * The company Name
	 */
	private String companyName;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAccess() {
		return access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
