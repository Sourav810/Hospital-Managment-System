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
import com.entity.ChangePassEntity;
import com.entity.User;

@WebServlet("/user_PS")
public class UserChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String Password = req.getParameter("password");
		String CPassword = req.getParameter("npassword");

		
		ChangePassEntity p = new ChangePassEntity(email, Password, CPassword);
		  
		  UserDao dao=new UserDao(DBConnect.getConn());
		  
		  boolean c=dao.ChangePassword(p);
		 

		
		  HttpSession session=req.getSession();
		  
		  if (c) { session.setAttribute("succMsg", "<i class=\"fa-solid fa-check\"></i> Password Changed");
		  resp.sendRedirect("signup.jsp");
		  
		  } else { session.setAttribute("errorMsg", "<i class=\"fa-solid fa-xmark\"></i> Password Not Changed");
		  resp.sendRedirect("user_login.jsp"); }
		 

	}

}
