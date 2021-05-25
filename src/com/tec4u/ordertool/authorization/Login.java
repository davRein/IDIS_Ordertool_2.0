/**
 * 
 */
package com.tec4u.ordertool.authorization;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tec4u.ordertool.bcrypt.HashCreator;

/**
 * @author d.reinerts
 *
 */
@Named ("login")
@SessionScoped
public class Login implements Serializable{

	private static final long serialVersionUID = -8731880247984879758L;
	
	private String strUsername = "";
	private String strPassword = "";
	private boolean isLoggedIn = false;
	private boolean isAdmin = false;
	
	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	
	/**
	 * @return the strUsername
	 */
	public String getStrUsername() {
		return strUsername;
	}
	/**
	 * @param strUsername the strUsername to set
	 */
	public void setStrUsername(String strUsername) {
		this.strUsername = strUsername;
	}
	/**
	 * @return the strPassword
	 */
	public String getStrPassword() {
		return strPassword;
	}
	/**
	 * @param strPassword the strPassword to set
	 */
	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	
	
	/**
	 * @return the isLoggedIn
	 */
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	/**
	 * @param isLoggedIn the isLoggedIn to set
	 */
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public void logout() {
		isLoggedIn = false;
	}
	
	/**
	 * Checks if the login is correct und sets isLoggedIn flag to true
	 */
	public void validateLogin() {
		if(LoginDAO.exist(strUsername)) {
			String strUserPassword = LoginDAO.getHashedPassword(strUsername);
			String strHash = HashCreator.getHash(strPassword, LoginDAO.getSalt(strUsername));
			
			if(strUserPassword.equals(strHash)) {
				isLoggedIn = true;
				isAdmin = LoginDAO.isAdmin(strUsername);
			} else {
				isLoggedIn = false;
				System.out.println("Password error: " + strPassword);
			}
		} else {
			System.out.println("User" + "doesn't exist");
		}
	}
	
}