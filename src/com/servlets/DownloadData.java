package com.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBConnection;

/**
 * Servlet implementation class DownloadData
 */
@WebServlet("/DownloadData")
public class DownloadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String uid=request.getParameter("email");	
			String fid=request.getParameter("fid");
			Connection con=DBConnection.connect();
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select * from store where uid='"+uid+"' ");
			
			OutputStream o = response.getOutputStream();
			if(r.next())
			{
				response.setContentType(r.getString(8));
				o.write(r.getBytes(6));
			}
			o.flush();
			o.close();
			}catch (Exception exception){
				exception.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
