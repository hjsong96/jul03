package com.poseidon.db;

import java.sql.Connection;
import java.sql.DriverManager;

//static 싱글턴
public class DBConnection {
	private static DBConnection dbConn = null;
	
	//생성자
	private DBConnection() {}
	
	//싱글턴 인스턴스를 반환하는 메소드
	public synchronized static DBConnection getInstance() {
		if (dbConn == null) {
			dbConn = new DBConnection(); 
		}
		return dbConn;
	}
	
	//getConn 접속 정보를 내보내줌
	public Connection getConnection() {
		Connection conn = null;
		//			  jdbc:mariadb://localhost:3306/choongang;
		//			  jdbc:mariadb://127.0.0.1:3306/choongang;
		String url = "jdbc:mariadb://localhost:3306/choongang";
		String id = "hjsong96";
		String pw = "0614";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); //마리아db에 있는 드라이버 가져와 쓸거다.
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
