/**
 * 
 */
package com.tec4u.ordertool.registrations;

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
public class TableDAO {
	public static List<RegistrationData> getRegistrationTableValues(int nStatus) {
		List<RegistrationData> regList = new ArrayList<RegistrationData>();
		String sql = "SELECT id, company, lastname, firstname, mailaddress, country, date "
				+ "FROM idis_ordertool.registrations "
				+ "WHERE status = " + nStatus + ";";

		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				regList.add(new RegistrationData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));

			}
			conn.close();
			return regList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static RegistrationData getCustomerData(int nId) {
		RegistrationData regData = null;
		String sql = "SELECT id, company, address, mailaddress, phone, date "
				+ "FROM registrations "
				+ "WHERE id = ?;";
		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, nId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				regData = new RegistrationData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			return regData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
