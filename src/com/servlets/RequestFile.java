package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.KeyRequestBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class RequestFile
 */
@WebServlet("/RequestFile")
public class RequestFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String fid = request.getParameter("fid");
		HttpSession session = request.getSession(false);
	//	String email = request.getParameter("email");
		String email = (String) session.getAttribute("email");
		String sql = "select uid from store where fid='" + fid + "'";
		String own = DBConnection.getName(sql);
		Date d = new Date();
		String da = "" + d;
		sql = "select * from filerequest where fid='" + fid + "' and userid='"
				+ email + "'";
		if (DBConnection.getData(sql) == true) {
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Already Made Request For Keys');");
			o.println("window.location='FileRequests.jsp';</script>");
		} else {
			KeyRequestBean kb = new KeyRequestBean();
			kb.setFid(fid);
			kb.setOid(own);
			kb.setUserid(email);
			kb.setDate1(da);
			sql = "insert into filerequest values(?,?,?,?,?)";
			int i = DBConnection.sendRKeys(sql, kb);
			if(i > 0){
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Key Request Sent Successfully');");
				o.println("window.location='FileRequests.jsp';</script>");
			}else{
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Keys request not sent');");
				o.println("window.location='FileRequests.jsp';</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
