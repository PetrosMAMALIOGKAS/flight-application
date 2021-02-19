package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoContext {
private static Connection conn;
	
	public static Connection getConnection() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Vols_server_simplon?serverTimezone=UTC","root","root");
			return conn;
		}
		catch(Exception e){
			System.out.println(e); 
		}
		return null;
	}
	
	public VolDao getVolDao() {
		
		return new VolDaoImpl(this);
		
	}
	
	public SiteDao getSiteDao() {
		
		return new SiteDaoImpl(this);
		
	}

}
