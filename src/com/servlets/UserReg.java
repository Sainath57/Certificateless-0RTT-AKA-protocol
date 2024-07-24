package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String gen = request.getParameter("gender");
		String pass = request.getParameter("password");
		UserBean ub = new UserBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setAge(age);
		ub.setGender(gen);
		ub.setPassword(pass);
		String sql = "insert into user values(?,?,?,?,?,?)";
		int i = DBConnection.setUser(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Register Successfully...');");
			o.println("window.location='UserReg.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details/Already Exist');");
			o.println("window.location='index.html';</script>");
		}
	}

}
