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
 * Servlet implementation class CSPPY
 */
@WebServlet("/CSPPK")
public class CSPPK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSPPK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		/*String uid=(String)session.getAttribute("email");*/
		String cid=request.getParameter("cspemail");
		String cpk = PortNumber.getCSPPk();
		/*String trapdoorkey=DBConnection.getkey(fid);*/
		System.out.println("kkkkkkkkk"+cid);
		Connection con=DBConnection.connect();
		
		try {
			String	sql = "select * from csppk where cid='" + cid + "' ";
			if (DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Already Private Keys Generated Successfully');");
				pw.println("window.location='CSPKeyGen.jsp';</script>");
			} else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into csppk values('KGC','"+cid+"','"+cpk+"') ");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Private Keys (pk) For "+cid+" are Generated Successfully');");
			 pw.println("location='CSPKeyGen.jsp';");
			 pw.println("</script>");
		//	response.sendRedirect("CSPKeyGen.jsp");
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
