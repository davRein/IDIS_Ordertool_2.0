/**
 * 
 */
package com.tec4u.ordertool.settings;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named("p_const")
@RequestScoped
public class Labels implements Serializable {

	private static final long serialVersionUID = -4975059604829526490L;
	private String strTitle = "IDIS Ordertool 2.0";
	private String strCopyright = " Tec4U Ingenieursgesellschaft mbH";
	private String strYear = "2021";
	private String strTec4u_url = "https://www.tec4u.com";

	/**
	 * @return the strTitle
	 */
	public String getStrTitle() {
		return strTitle;
	}

	/**
	 * @param strTitle the strTitle to set
	 */
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	/**
	 * @return the strCopyright
	 */
	public String getStrCopyright() {
		return strCopyright;
	}

	/**
	 * @return the strYear
	 */
	public String getStrYear() {
		return strYear;
	}

	/**
	 * @return the strTec4u_url
	 */
	public String getStrTec4u_url() {
		return strTec4u_url;
	}

}
