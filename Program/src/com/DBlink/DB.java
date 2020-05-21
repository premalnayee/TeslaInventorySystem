package com.DBlink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private static Connection conn;
	private static Statement stmt;

	public DB() {
	}
	
	public static void connect() {
		try {
			//Class.forName(DBConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
			stmt = conn.createStatement();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet exQuery(String query) {
		ResultSet r = null;
		try {
			r = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public static int exUpdate(String query) {
		int changedKey = 0;
		try {
			changedKey = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changedKey;
	}
	

	public void createActors(String fName, String lName) throws SQLException {
//		stmt.execute("CREATE TABLE actor  (first_name VARCHAR(10), last_name VARCHAR(20))");
		stmt.executeUpdate(
				"INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('" + fName + "', '" + lName + "')");
	}

	public void readActors() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM actor");
		while (rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
		}
	}

	public void updateActor(String fName, String lName, int id) throws SQLException {
		stmt.executeUpdate(
				"UPDATE actor SET first_name = '" + fName + "', last_name = '" + lName + "' WHERE actor_id = " + id);
	}

	public void deleteActor(int id) throws SQLException {
		stmt.executeUpdate("DELETE FROM actor WHERE actor_id = " + id);
	}

	/**
	 * @return the stmt
	 */
	public static Statement getStmt() {
		return stmt;
	}

	/**
	 * @param stmt the stmt to set
	 */
	public static void setStmt(Statement stmt) {
		DB.stmt = stmt;
	}

	/**
	 * @return the conn
	 */
	public static Connection getConn() {
		return conn;
	}

	/**
	 * @param conn the conn to set
	 */
	public static void setConn(Connection conn) {
		DB.conn = conn;
	}
	
	

}
