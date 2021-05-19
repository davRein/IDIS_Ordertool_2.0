/**
 * 
 */
package com.tec4u.ordertool.administration;

/**
 * @author d.reinerts
 *
 */
public class Users {
	
	private String strUsername = "";
	private String strLastname = "";
	private String strFirstname = "";
	private String strMail = "";
	private String strRole = "";
	private String strStatus = "";
	private String strHash = "";
	private String strSalt = "";
	
	public Users(String strUsername, String strLastname, String strFirstname, String strMail, String strRole, String strStatus) {
		this.strUsername = strUsername;
		this.strFirstname = strFirstname;
		this.strLastname = strLastname;
		this.strMail = strMail;
		this.strRole = strRole;
		this.strStatus = strStatus;
	}
	
	public Users(String strUsername, String strLastname, String strFirstname, String strMail, String strRole, String strStatus, String strHash, String strSalt) {
		this.strUsername = strUsername;
		this.strFirstname = strFirstname;
		this.strLastname = strLastname;
		this.strMail = strMail;
		this.strRole = strRole;
		this.strStatus = strStatus;
		this.strHash = strHash;
		this.strSalt = strSalt;
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

	/**
	 * @return the strHash
	 */
	public String getStrHash() {
		return strHash;
	}

	/**
	 * @param strHash the strHash to set
	 */
	public void setStrHash(String strHash) {
		this.strHash = strHash;
	}

	/**
	 * @return the strSalt
	 */
	public String getStrSalt() {
		return strSalt;
	}

	/**
	 * @param strSalt the strSalt to set
	 */
	public void setStrSalt(String strSalt) {
		this.strSalt = strSalt;
	}
	
	
	
}
