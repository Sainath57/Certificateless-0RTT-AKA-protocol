package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.CSPBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class CSPReg
 */
@WebServlet("/CSPReg")
public class CSPReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSPReg() {
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
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		String CSPName=request.getParameter("cspname");
		String CSPEmail=request.getParameter("cspemail");
		String CSPPassword=request.getParameter("csppassword");
		CSPBean b=new CSPBean();
		b.setCSPName(CSPName);
		b.setCSPEmail(CSPEmail);
		b.setCSPPassword(CSPPassword);
		String sql="insert into cspreg values (0,?,?,?)";
		int i=DBConnection.setCsp(sql,b);
		if(i > 0){
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Register Successfully...');");
			pw.println("window.location='CSPReg.jsp';</script>");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details/Already Exist');");
			pw.println("window.location='index.html';</script>");
		}
	}

}
