package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/* the values like fullname, email, password are coming from signup.jsp page and we will use these values later 
		 * in UserDao.java for opration in database */
		try {
			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			/* before storing these values in database we need to set values in user entity and pass object*/
			User u = new User(fullName, email, password);
			
			UserDao dao=new UserDao(DBConnect.getConn());
			
			boolean f=dao.register(u);
			
			HttpSession session=req.getSession();
			
			if (f) {				
				session.setAttribute("sucMsg", "Register Succesfully");
				resp.sendRedirect("signup.jsp");
				
				System.out.println("Register Succesful showing on console");
			}
			else {
				session.setAttribute("errorMsg", "Something Wrong on Server");
				resp.sendRedirect("signup.jsp");
				
				System.out.println("Something Wrong on Server showing on console");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
