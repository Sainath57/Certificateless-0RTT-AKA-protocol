package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

/**
 * Servlet implementation class CSPLogin
 */
@WebServlet("/CSPLogin")
public class CSPLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSPLogin() {
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
		String cid = request.getParameter("cspemail");
		String pwd = request.getParameter("csppassword");
		HttpSession session = request.getSession();
		System.out.println("username and password"+cid+pwd);
		String sql = "select * from cspreg where cspemail='"+cid+"' and csppassword='"+pwd+"'";
		boolean b = DBConnection.getData(sql);
		if(b == true){
			session.setAttribute("cspemail", cid);
			sql = "select cspname from cspreg where cspemail='"+cid+"'";
			String name = DBConnection.getName(sql);
			session.setAttribute("cspname", name);
			response.sendRedirect("CSPHome.jsp");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details');");
			pw.println("window.location='CSPLogin.jsp';</script>");
		}
	}

}
