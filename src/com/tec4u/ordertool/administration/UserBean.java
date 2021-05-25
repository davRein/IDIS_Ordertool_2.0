/**
 * 
 */
package com.tec4u.ordertool.administration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.tec4u.ordertool.bcrypt.BCrypt;

/**
 * @author d.reinerts
 *
 */
@Named("user")
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 6036210150983590771L;
	private List<Users> userList = new ArrayList<Users>();
	private String strUsername = "";
	private String strLastname = "";
	private String strFirstname = "";
	private String strMail = "";
	private String strRole = "";
	private String strStatus = "4";
	private boolean userExist = false;
	private String strSalt = "";
	private String strHash = "";
	private String strGeneratedPassword = "";
	AccountMails am = new AccountMails();

	public void createUser() {
		List<Users> userList = new ArrayList<Users>();
		
		
		if (!userExists()) {
			strGeneratedPassword = SecureRandomPassword.generateStrongPassword();
			//StoreUsername.storeUsernameInFile(strUsername, strGeneratedPassword);
			strSalt = BCrypt.gensalt(5);
			strHash = BCrypt.hashpw(strGeneratedPassword, strSalt);
			
			userList.add(new Users(strUsername, strLastname, strFirstname, strMail, strRole, strStatus, strHash, strSalt));
			AdminDAO.insertUser(userList);
			am.sendEmail(strMail, strGeneratedPassword);
			userExist = false;
		} else
			userExist = true;
	}

	private boolean userExists() {
		if (AdminDAO.userExist(strUsername) == 1) {
			userExist = true;
			return true;
		} else if (AdminDAO.userExist(strUsername) == 0) {
			userExist = false;
			return false;
		} else {
			System.out.println("Something went terribly wrong dude");
			return true;
		}
	}

	/**
	 * @return the userExist
	 */
	public boolean isUserExist() {
		return userExist;
	}

	/**
	 * @param userExist the userExist to set
	 */
	public void setUserExist(boolean userExist) {
		this.userExist = userExist;
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
	 * @return the strLastname
	 */
	public String getStrLastname() {
		return strLastname;
	}

	/**
	 * @param strLastname the strLastname to set
	 */
	public void setStrLastname(String strLastname) {
		this.strLastname = strLastname;
	}

	/**
	 * @return the strFirstname
	 */
	public String getStrFirstname() {
		return strFirstname;
	}

	/**
	 * @param strFirstname the strFirstname to set
	 */
	public void setStrFirstname(String strFirstname) {
		this.strFirstname = strFirstname;
	}

	/**
	 * @return the strMail
	 */
	public String getStrMail() {
		return strMail;
	}

	/**
	 * @param strMail the strMail to set
	 */
	public void setStrMail(String strMail) {
		this.strMail = strMail;
	}

	/**
	 * @return the strRole
	 */
	public String getStrRole() {
		return strRole;
	}

	/**
	 * @param strRole the strRole to set
	 */
	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}

	/**
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public List<Users> getUserList() {
		userList = AdminDAO.getAllUsers();
		return userList;
	}

}
