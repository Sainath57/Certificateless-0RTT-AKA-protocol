package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.KeyRequestBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class Send
 */
@WebServlet("/Send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send() {
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
		String uid = request.getParameter("email");
		System.out.println("fffffff"+uid);
		String sql = "select * from ukeys where fid='" + fid + "' and userid='"
				+ uid + "'";
		boolean b = DBConnection.getData(sql);
		if (b == true) {
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Cloud User Already Recieved The Session Keys');");
			o.println("window.location='UserHome.jsp';</script>");
		} else {
			sql = "select * from store where fid='" + fid + "'";
			String key1 = "";
			List<String> lt = DBConnection.getOwnerKeys(sql);
			Iterator<String> itr = lt.iterator();
			while (itr.hasNext()) {
				key1 = itr.next();
				
			}
			KeyRequestBean kb = new KeyRequestBean();
			kb.setFid(fid);
			kb.setUserid(uid);
			kb.setKey1(key1);
			sql = "insert into ukeys values(?,?,?)";
			int i = DBConnection.sendKeys(sql, kb);
			if(i > 0){
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Session Keys are sent to Cloud User successfully');");
				o.println("window.location='UserHome.jsp';</script>");
			}else{
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Session Keys are not sent to Cloud User');");
				o.println("window.location='UserHome.jsp';</script>");
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
