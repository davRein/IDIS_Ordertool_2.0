/**
 * 
 */
package com.tec4u.ordertool.administration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tec4u.ordertool.database.DatabaseConnect;

/**
 * @author d.reinerts
 *
 */

public class AdminDAO {
	
	/**
	 * Returns a List with all users from the staff table 
	 * @return
	 */
	public static List<Users> getAllUsers() {
		List<Users> userList = new ArrayList<Users>();

		String sql = "SELECT staff_data.username, staff_data.lastname, staff_data.firstname, staff_data.mail, rights.role, user_status.status\r\n"
				+ "FROM staff_data \r\n"
				+ "INNER JOIN rights ON staff_data.role = rights.rights_id\r\n"
				+ "INNER JOIN user_status ON staff_data.status = user_status.status_id;";

		Connection conn = DatabaseConnect.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userList.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			conn.close();
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static int userExist(String strUsername) {
		String sql = "SELECT EXISTS (SELECT username "
				+ "FROM idis_ordertool.staff_data "
				+ "WHERE username = ?);";
		Connection conn = DatabaseConnect.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, strUsername);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;
		
	}
	
	public static void insertUser(List<Users> newUser) {
		String sql = "INSERT INTO idis_ordertool.staff_data (username, password, salt, firstname, lastname, mail, role, status, pwd_changed)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, false);";
		
		int nRoleId = 0;
		switch (newUser.get(0).getStrRole()) {
		case "Admin":
			nRoleId = 2;
			break;
		case "User":
			nRoleId = 3;
			break;
		case "Language":
			nRoleId = 4;
			break;
	}
		
		if(newUser.isEmpty()) {
			System.out.println("EMPTY");
		} else System.out.println("NOT EMPTY");
		Connection conn = DatabaseConnect.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newUser.get(0).getStrUsername());
			ps.setString(2, newUser.get(0).getStrHash());
			ps.setString(3, newUser.get(0).getStrSalt());
			ps.setString(4, newUser.get(0).getStrFirstname());
			ps.setString(5, newUser.get(0).getStrLastname());
			ps.setString(6, newUser.get(0).getStrMail());
			ps.setInt(7, nRoleId);
			ps.setInt(8, Integer.parseInt(newUser.get(0).getStrStatus()));
			
			
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
