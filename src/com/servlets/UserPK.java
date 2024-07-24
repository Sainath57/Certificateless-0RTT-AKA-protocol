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
 * Servlet implementation class UserPK
 */
@WebServlet("/UserPK")
public class UserPK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw =response.getWriter();
		HttpSession session=request.getSession();
		/*String uid=(String)session.getAttribute("email");*/
		String uid=request.getParameter("email");
		String pk = PortNumber.getUserPk();
		/*String trapdoorkey=DBConnection.getkey(fid);*/
		System.out.println("kkkkkkkkk"+uid);
		Connection con=DBConnection.connect();
		
		try {
		String	sql = "select * from userpk where uid='" + uid + "' ";
			if (DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Already Private Keys Generated Successfully');");
				pw.println("window.location='UserKeyGen.jsp';</script>");
			} else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into userpk values('KGC','"+uid+"','"+pk+"') ");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Private Keys For Cloud User("+uid+") are Generated Successfully');");
			 pw.println("location='UserKeyGen.jsp';");
			 pw.println("</script>");
		//	response.sendRedirect("UserKeyGen.jsp");
		} }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	try {
		Statement st=con.createStatement();
		int i=st.executeUpdate("insert into userpk values('KGC','"+uid+"','"+pk+"') ");
		 pw.println("<script type=\"text/javascript\">");
		 pw.println("alert('Private Keys For Cloud User("+uid+") are Generated Successfully');");
		 pw.println("location='UserKeyGen.jsp';");
		 pw.println("</script>");
	//	response.sendRedirect("UserKeyGen.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
}
}
