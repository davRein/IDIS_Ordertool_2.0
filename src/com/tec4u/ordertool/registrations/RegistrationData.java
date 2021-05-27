/**
 * 
 */
package com.tec4u.ordertool.registrations;

/**
 * @author d.reinerts
 *
 */
public class RegistrationData {
	
	private int nCustomerId = 0;
	private String strLastname = "";
	private String strFirstname = "";
	private String strMailaddress = "";
	private String strLanguage = "";
	private String strCompany = "";
	private String strPhone = "";
	private String strAddress = "";
	private String strPlz = "";
	private String strCity = "";
	private String strCountry = "";
	private String strOrderedAs = "";
	private String strActivity = "";
	private String strDate = "";
	private String strStatus = "";


	public RegistrationData(){
		
	}

	public RegistrationData(int nCustomerId, String strLastname, String strFirstname, String strMailaddress, String strLanguage,
			String strCompany, String strPhone, String strAddress, String strPlz, String strCity, String strCountry,
			String strOrderedAs, String strActivity, String strDate, String strStatus) {

		this.nCustomerId = nCustomerId;
		this.strLastname = strLastname;
		this.strFirstname = strFirstname;
		this.strMailaddress = strMailaddress;
		this.strLanguage = strLanguage;
		this.strCompany = strCompany;
		this.strPhone = strPhone;
		this.strAddress = strAddress;
		this.strPlz = strPlz;
		this.strCity = strCity;
		this.strCountry = strCountry;
		this.strOrderedAs = strOrderedAs;
		this.strActivity = strActivity;
		this.strDate = strDate;
		this.strStatus = strStatus;
	}

	public RegistrationData(int nCustomerId, String strCompany, String strAddress, String strMailaddress, String strPhone, String strDate) {
		this.nCustomerId = nCustomerId;
		this.strCompany = strCompany;
		this.strAddress = strAddress;
		this.strMailaddress = strMailaddress;
		this.strPhone = strPhone;
		this.strDate = strDate;
	}
	
	public RegistrationData(int nCustomerId, String strCompany, String strLastname, String strFirstname, String strMailaddress, String strCountry, String strDate) {
		this.nCustomerId = nCustomerId;
		this.strCompany = strCompany;
		this.strLastname = strLastname;
		this.strFirstname = strFirstname;
		this.strMailaddress = strMailaddress;
		this.strCountry = strCountry;
		this.strDate = strDate;
	}
	
	/**
	 * @return the nCustomerId
	 */
	public int getnCustomerId() {
		return nCustomerId;
	}




	/**
	 * @param nCustomerId the nCustomerId to set
	 */
	public void setnCustomerId(int nCustomerId) {
		this.nCustomerId = nCustomerId;
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
	 * @return the strMailaddress
	 */
	public String getStrMailaddress() {
		return strMailaddress;
	}

	/**
	 * @param strMailaddress the strMailaddress to set
	 */
	public void setStrMailaddress(String strMailaddress) {
		this.strMailaddress = strMailaddress;
	}

	/**
	 * @return the strLanguage
	 */
	public String getStrLanguage() {
		return strLanguage;
	}

	/**
	 * @param strLanguage the strLanguage to set
	 */
	public void setStrLanguage(String strLanguage) {
		this.strLanguage = strLanguage;
	}

	/**
	 * @return the strCompany
	 */
	public String getStrCompany() {
		return strCompany;
	}

	/**
	 * @param strCompany the strCompany to set
	 */
	public void setStrCompany(String strCompany) {
		this.strCompany = strCompany;
	}

	/**
	 * @return the strPhone
	 */
	public String getStrPhone() {
		return strPhone;
	}

	/**
	 * @param strPhone the strPhone to set
	 */
	public void setStrPhone(String strPhone) {
		this.strPhone = strPhone;
	}

	/**
	 * @return the strAddress
	 */
	public String getStrAddress() {
		return strAddress;
	}

	/**
	 * @param strAddress the strAddress to set
	 */
	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}

	/**
	 * @return the strPlz
	 */
	public String getStrPlz() {
		return strPlz;
	}

	/**
	 * @param strPlz the strPlz to set
	 */
	public void setStrPlz(String strPlz) {
		this.strPlz = strPlz;
	}

	/**
	 * @return the strCity
	 */
	public String getStrCity() {
		return strCity;
	}

	/**
	 * @param strCity the strCity to set
	 */
	public void setStrCity(String strCity) {
		this.strCity = strCity;
	}

	/**
	 * @return the strCountry
	 */
	public String getStrCountry() {
		return strCountry;
	}

	/**
	 * @param strCountry the strCountry to set
	 */
	public void setStrCountry(String strCountry) {
		this.strCountry = strCountry;
	}

	/**
	 * @return the strOrderedAs
	 */
	public String getStrOrderedAs() {
		return strOrderedAs;
	}

	/**
	 * @param strOrderedAs the strOrderedAs to set
	 */
	public void setStrOrderedAs(String strOrderedAs) {
		this.strOrderedAs = strOrderedAs;
	}

	/**
	 * @return the strActivity
	 */
	public String getStrActivity() {
		return strActivity;
	}

	/**
	 * @param strActivity the strActivity to set
	 */
	public void setStrActivity(String strActivity) {
		this.strActivity = strActivity;
	}

	/**
	 * @return the strDate
	 */
	public String getStrDate() {
		return strDate;
	}

	/**
	 * @param strDate the strDate to set
	 */
	public void setStrDate(String strDate) {
		this.strDate = strDate;
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

}
