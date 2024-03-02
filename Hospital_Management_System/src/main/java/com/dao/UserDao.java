package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.ChangePassEntity;
import com.entity.User;

/* This code is written for the operations on the user input with database like insert , update , delete etc */
public class UserDao {

	private Connection conn;

	/* Constructor */
	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	/* Seprate Methodes for each Operation */

	public boolean register(User u) {
		boolean f = false;

		try {
			String sql = "insert into user_dtls(full_name, email, password) values(?,?,?) ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFullName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	/*
	 * this is a method to check the email and password given by user is valid or
	 * not if yes then we return a User Object
	 */
	/* This method is to check to login details of a user */
	public User login(String em, String psw) {
		User u = null;

		try {

			String sql = "select * from user_dtls where email =? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			/*
			 * This will check if the user is available or not and if it does exist it will
			 * create a new object
			 */
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	
	/* This code is for changing the password */
	
	  public boolean ChangePassword(ChangePassEntity p) {
	  
	  boolean c = false;
	  
	  try {
	  
	  String sql = "update user_dtls set password = ? where email = ?";
	  PreparedStatement ps = conn.prepareStatement(sql); 
	  ps.setString(1, p.getEmail());
	  ps.setString(2, p.getNpassword());
	  
	  ResultSet rs = ps.executeQuery();
	  
	  int i = ps.executeUpdate();
	  
	  if (i == 1) { c = true; }
	  
	  } catch (Exception e) { e.printStackTrace(); }
	  
	  return c;
	  
	  }
	  
		/* Experiment End */
	 

}
