/**
 * 
 */
package com.tec4u.ordertool.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author d.reinerts
 *
 */
public class DatabaseConnect {
	private static String db_URL = "jdbc:mysql://82.165.185.245:3306";
	private static String db_NAME = "/idis_ordertool";
	private static String db_USR = "idisdb_admin";
	private static String db_PWD = "Id!sDB2020!";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(db_URL + db_NAME, db_USR, db_PWD);
			return conn;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (Exception ex) {
		}
	}
}
