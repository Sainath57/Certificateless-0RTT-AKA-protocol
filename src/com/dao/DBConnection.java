package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.AttackBean;
import com.beans.CSPBean;
import com.beans.KeyRequestBean;
import com.beans.StoreBean;
import com.beans.UserBean;

public class DBConnection {
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc08-2020", "root", "Sa1@mysql");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return con;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return con;
		}

	}
	// Method for user Registration
	public static int setUser(String sql, UserBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getAge());
			ps.setString(4, ub.getGender());
			ps.setString(5, ub.getPassword());
			ps.setString(6,"pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static ResultSet getData1(String sql) {
		// TODO Auto-generated method stub
			Connection con = connect();
			ResultSet rs = null;
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
		}
	public static String getName(String sql) {
		// TODO Auto-generated method stub
		String name ="";
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString(1);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;

	}
	public static int setCsp(String sql, CSPBean b) {
		// TODO Auto-generated method stub
		int i=0;
		Connection con=DBConnection.connect();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, b.getCSPName());
			ps.setString(2, b.getCSPEmail());
			ps.setString(3, b.getCSPPassword());
			i=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getcsp() throws SQLException
	{
		Connection con=DBConnection.connect();
		java.sql.Statement s=con.createStatement();
		ResultSet r=s.executeQuery("select * from cspreg ");
		return r;
	}
	public static List<String> getCSP(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				/*lt.add(rs.getString(2));*/
				lt.add(rs.getString(2));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static ResultSet getRequests() throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from request where status='pending'";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static List<String> getUserReq(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				//lt.add(rs.getString(3));
				//lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static ResultSet getallcsp() throws SQLException
	{
		Connection con=DBConnection.connect();
		java.sql.Statement s=con.createStatement();
		ResultSet r=s.executeQuery("select * from cspreg ");
		return r;
	}
	public static ResultSet getSetup() throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from user ";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static ResultSet getSetup2() throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from cspreg ";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static int Store(String sql, StoreBean u) {
	// TODO Auto-generated method stub
	int i = 0;
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
	//	ps.setString(1, u.getFid());
		ps.setString(1, u.getUid());
		ps.setString(2, u.getCid());
		ps.setString(3, u.getFilename());
		
		ps.setString(4, u.getFiledata());
		InputStream photo = u.getPhoto();
		if (photo != null) {
			ps.setBinaryStream(5, photo);
		}
		ps.setString(6, u.getEnc());
		ps.setString(7, u.getContent());
		ps.setString(8, u.getSessionkey());
	
		i = ps.executeUpdate();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
	public static List<String> getCSPEmail(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				//lt.add(rs.getString(2));
			//	lt.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
		public static int update(String sql) {
			// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		public static List<String> getReq(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
				//  lt.add(rs.getString(4));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getAllUser(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(4));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getPrivateKey(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getCSPPrivateKey(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getStoredData(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(4));
					lt.add(rs.getString(9));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		 public static ResultSet getUser() throws SQLException
			{
				Connection con =DBConnection.connect();
				String sql="select * from store ";
				Statement s=con.createStatement();
				ResultSet r=s.executeQuery(sql);
				return r;
			}
		public static int sendRKeys(String sql, KeyRequestBean kb) {
			// TODO Auto-generated method stub
				int i = 0;
				Connection con = connect();
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, kb.getFid());
					ps.setString(2, kb.getOid());
					ps.setString(3, kb.getUserid());
					ps.setString(4, "pending");
					ps.setString(5, kb.getDate1());
					i = ps.executeUpdate();
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return i;
		}
		public static List<String> getOkey(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(5));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getKey(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(4));
					
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getOwnerKeys(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					//lt.add(rs.getString(7));
					//lt.add(rs.getString(8));
					lt.add(rs.getString(9));
					
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static int sendKeys(String sql, KeyRequestBean kb) {
			// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, kb.getFid());
				ps.setString(2, kb.getUserid());
				ps.setString(3, kb.getKey1());
				i = ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		public static List<String> getFid(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getUKeys(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(3));
				//	lt.add(rs.getString(4));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
		public static List<String> getKeysss(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
				//	lt.add(rs.getString(8));
					lt.add(rs.getString(9));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
			public static int getCount(String sql) {
				// TODO Auto-generated method stub
				int i = 0;
				Connection con = connect();
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						i = rs.getInt(1);
					}
					rs.close();
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return i;
			}
				public static int setAttack(String sql, com.beans.AttackBean ab) {
					// TODO Auto-generated method stub
					int i = 0;
					Connection con = connect();
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, ab.getFid());
						ps.setString(2, ab.getOid());
						ps.setString(3, ab.getEmail());
						ps.setString(4, ab.getIp());
						ps.setString(5, ab.getDate1());
						ps.setInt(6, ab.getFcount());
						i = ps.executeUpdate();
						ps.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return i;
				}
				public static ResultSet getData2(String sql) {
					// TODO Auto-generated method stub
						Connection con = connect();
						ResultSet rs = null;
						try{
							PreparedStatement ps = con.prepareStatement(sql);
							rs = ps.executeQuery();
						}catch(SQLException e){
							e.printStackTrace();
						}
						return rs;
					}
				public static int userRegister(String sql1, UserBean ub) {
					// TODO Auto-generated method stub
						int i = 0;
						Connection con = connect();
						try{
							PreparedStatement ps = con.prepareStatement(sql1);
							ps.setString(1, ub.getName());
							ps.setString(2, ub.getEmail());
							ps.setString(3, ub.getAge());
							ps.setString(4, ub.getGender());
							ps.setString(5, ub.getPassword());
							ps.setString(6, "Approved");
							
							i = ps.executeUpdate();
						}catch(Exception e){
							e.printStackTrace();
						}
						return i;
					}
				 public static ResultSet getAttackers() throws SQLException
					{
						Connection con =DBConnection.connect();
						String sql="select * from attack ";
						Statement s=con.createStatement();
						ResultSet r=s.executeQuery(sql);
						return r;
					}
	}
