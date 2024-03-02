package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecialistDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/addSpecialist")
public class AddSpecialist  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String specName=req.getParameter("specName");
		
		/* creating SpecialistDao object and pass Specialist Name inside the method of this object*/
		SpecialistDao dao= new SpecialistDao(DBConnect.getConn());
		boolean f = dao.addSpecialist(specName);
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "<i class=\"fa-solid fa-check\"></i> Specialist Added");
			resp.sendRedirect("admin/index.jsp");
		}
		else {
			session.setAttribute("errorMsg", "<i class=\"fa-solid fa-xmark\"></i> Somthing Wrong On Server");
			resp.sendRedirect("index.jsp");
		}
		
	}

}
