/**
 * 
 */
package com.tec4u.ordertool.authorization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tec4u.ordertool.database.DatabaseConnect;

/**
 * @author d.reinerts
 *
 */
public class LoginDAO {
	public static String getSalt(String strUsername) {
		String strSalt = "";
		String sql = "SELECT salt FROM idis_ordertool.staff_data WHERE username = ?;";
		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, strUsername);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				strSalt = rs.getString(1);
			}
			return strSalt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getHashedPassword(String strUsername) {
		String strHashedPassword = "";
		String sql = "SELECT password FROM idis_ordertool.staff_data WHERE username = ?;";
		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, strUsername);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				strHashedPassword = rs.getString(1);
			}
			return strHashedPassword;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static boolean exist(String strUsername) {
		String sql_UserExist = "SELECT EXISTS (SELECT username FROM idis_ordertool.staff_data WHERE username = ?);";
		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql_UserExist);
			ps.setString(1, strUsername);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					return true;
				} else
					return false;
			}
			DatabaseConnect.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isAdmin(String strUsername) {
		String sql = "SELECT staff_data.role " + "FROM staff_data " + "WHERE staff_data.username = ?;";
		Connection conn = DatabaseConnect.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, strUsername);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 2) {
					return true;
				} else
					return false;
			}
			DatabaseConnect.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
