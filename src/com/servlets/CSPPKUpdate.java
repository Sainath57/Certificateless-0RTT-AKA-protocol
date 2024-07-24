package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBConnection;

/**
 * Servlet implementation class CSPPKUpdate
 */
@WebServlet("/CSPPKUpdate")
public class CSPPKUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSPPKUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String cid = request.getParameter("cspemail");
		String key1 = com.dao.RandomeString.getSaltString();
		String sql = "update csppk set csppk='"+key1+"' where cid='"+cid+"'";
		int i = DBConnection.update(sql);
		if(i > 0){
			/*Admin.count = 0;*/
			o.println("<script type=\"text/javascript\">");
			o.println("alert('"+cid+" Keys Updated Successfully...');");
			o.println("window.location='UpdateCSPPK.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('"+cid+" Keys Not Updated');");
			o.println("window.location='UpdateCSPPK.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
