package com.entity;

public class ChangePassEntity {

	/* Experiment Start for password change*/
	private String email;
	private String password;
	private String npassword;


	/*Constructor*/
	public ChangePassEntity(String email, String password, String npassword) {
		super();
		this.email = email;
		this.password = password;
		this.npassword = npassword;
	}
	
	/* Getter Setter */
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}
	
	
	
	/* Experiment End */
	
}
