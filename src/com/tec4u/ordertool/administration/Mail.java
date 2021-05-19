/**
 * 
 */
package com.tec4u.ordertool.administration;

/**
 * @author d.reinerts
 *
 */
public class Mail {
	private String strSMTP_Host = "";
	private String strProvider = "";
	private String strPort = "";
	private String strSourceMail = "";
	private String strPwd = "";
	private boolean isActivated = false;
	
	public Mail(String strSMTP_Host, String strProvider,String strPort, String strSourceMail, String strPwd) {
		this.strSMTP_Host = strSMTP_Host;
		this.strProvider = strProvider;
		this.strPort = strPort;
		this.strSourceMail = strSourceMail;
		this.strPwd = strPwd;
	}
	
	public Mail(String strSMTP_Host, String strPort, String strSourceMail, String strPwd) {
		this.strSMTP_Host = strSMTP_Host;
		this.strPort = strPort;
		this.strSourceMail = strSourceMail;
		this.strPwd = strPwd;
	}
	
	public Mail(String strSMTP_Host, String strProvider) {
		this.strSMTP_Host = strSMTP_Host;
		this.strProvider = strProvider;
	}
	
	
	/**
	 * @return the strProvider
	 */
	public String getStrProvider() {
		return strProvider;
	}

	/**
	 * @param strProvider the strProvider to set
	 */
	public void setStrProvider(String strProvider) {
		this.strProvider = strProvider;
	}

	/**
	 * @return the strSMTP_Host
	 */
	public String getStrSMTP_Host() {
		return strSMTP_Host;
	}

	/**
	 * @param strSMTP_Host the strSMTP_Host to set
	 */
	public void setStrSMTP_Host(String strSMTP_Host) {
		this.strSMTP_Host = strSMTP_Host;
	}

	/**
	 * @return the strPort
	 */
	public String getStrPort() {
		return strPort;
	}

	/**
	 * @param strPort the strPort to set
	 */
	public void setStrPort(String strPort) {
		this.strPort = strPort;
	}

	/**
	 * @return the strSourceMail
	 */
	public String getStrSourceMail() {
		return strSourceMail;
	}

	/**
	 * @param strSourceMail the strSourceMail to set
	 */
	public void setStrSourceMail(String strSourceMail) {
		this.strSourceMail = strSourceMail;
	}

	/**
	 * @return the strPwd_hash
	 */
	public String getStrPwd() {
		return strPwd;
	}

	/**
	 * @param strPwd_hash the strPwd_hash to set
	 */
	public void setStrPwd(String strPwd) {
		this.strPwd = strPwd;
	}

	
	/**
	 * @return the isActivated
	 */
	public boolean isActivated() {
		return isActivated;
	}

	/**
	 * @param isActivated the isActivated to set
	 */
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	
}
