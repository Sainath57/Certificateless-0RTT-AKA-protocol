package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

/**
 * Servlet implementation class SendRequest
 */
@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		String uid=(String)session.getAttribute("email");
		//String uid=request.getParameter("email");
		String cid=request.getParameter("cid");
		String cspemail=request.getParameter("cspemail");
	//	String cspemail=(String)session.getAttribute("cspemail");
		System.out.println(uid);
		System.out.println(cspemail);
		System.out.println(cid);
		Connection con=DBConnection.connect();
		try {
			String	sql = "select * from request where uid='" + uid + "' and cid='"+cid+"'";
			if (DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('("+uid+")Already Made a request');");
				pw.println("window.location='Enroll.jsp';</script>");
			} else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into request values('"+cid+"','"+uid+"','"+cspemail+"','Pending')");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Cloud User("+uid+")Request Sent Successfully...');");
			 pw.println("location='Enroll.jsp';");
			 pw.println("</script>");
			//response.sendRedirect("Enroll.jsp");
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
