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
public class EmailDAO {
	public static List<Mail> getMailSettings() {
		List<Mail> mailSettingsList = new ArrayList<Mail>();

		String sql = "SELECT smtp_host, provider FROM email_settings";

		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mailSettingsList.add(new Mail(rs.getString(1), rs.getString(2)));
			}
			conn.close();
			return mailSettingsList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addMailServer(String strSmtp_host, String strProvider, String strPort, String strSourceMail,
			String strPwd) {
		System.out.println("DAo CALLED");
		String sql = "INSERT INTO email_settings (smtp_host, provider, port, source_mail, activated, pwd) "
				+ "VALUES (?, ?, ?, ?, false, ?);";
		Connection conn = DatabaseConnect.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, strSmtp_host);
			ps.setString(2, strProvider);
			ps.setString(3, strPort);
			ps.setString(4, strSourceMail);
			ps.setString(5, strPwd);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void activateMailSettings(String strSmtp_host) {
		resetActivition();
		String sqlActivate = "UPDATE email_settings SET activated = true WHERE smtp_host = '" + strSmtp_host + "';";

		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sqlActivate);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void changeMailServer(Mail mailSettings, String strSmtp_host) {
		String sql = "UPDATE email_settings SET smtp_host = ?, provider = ?, port = ?, source_mail = ?, activated = false, pwd = ? WHERE smtp_host = '"
				+ strSmtp_host + "';";
		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mailSettings.getStrSMTP_Host());
			ps.setString(2, mailSettings.getStrProvider());
			ps.setString(3, mailSettings.getStrPort());
			ps.setString(4, mailSettings.getStrSourceMail());
			ps.setString(5, mailSettings.getStrPwd());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Mail> getMailServerDetails() {
		String sql = "SELECT smtp_host, provider, port, source_mail, pwd " + "FROM idis_ordertool.email_settings;";

		Connection conn = DatabaseConnect.getConnection();
		List<Mail> mailServerDetails = new ArrayList<Mail>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mailServerDetails.add(
						new Mail(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			conn.close();
			return mailServerDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void resetActivition() {
		String sqlReset = "UPDATE email_settings SET activated = false;";

		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sqlReset);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Mail> getCurrentMailserver() {
		String sql = "SELECT smtp_host, provider FROM email_settings WHERE activated = true;";
		List<Mail> currentServerList = new ArrayList<Mail>();
		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				currentServerList.add(new Mail(rs.getString(1), rs.getString(2)));
			}
			conn.close();
			return currentServerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Mail getMailServerSettingsToSendToNewUsers() {
		String sql = "SELECT smtp_host, port, source_mail, pwd " + "FROM email_settings " + "WHERE activated = true;";
		Mail m = null;
		Connection conn = DatabaseConnect.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				System.out.println("RS is empty");
			} else {
				m = new Mail(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			

			/*
			 * System.out.println("smtp_host: " + rs.getString(1));
			 * System.out.println("port: " + rs.getString(2));
			 * System.out.println("source_mail: " + rs.getString(3));
			 * System.out.println("pwd: " + rs.getString(4));
			 */
			conn.close();
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}