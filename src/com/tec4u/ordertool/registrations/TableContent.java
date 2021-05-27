/**
 * 
 */
package com.tec4u.ordertool.registrations;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author d.reinerts
 *
 */

@Named ("tbl_content")
@SessionScoped
public class TableContent implements Serializable{

	private static final long serialVersionUID = -159858519276751031L;
	private RegistrationData customerData;
	
	private final int WAITING_LIST_ID = 4;
	private final int REGISTRATION_LIST_ID = 8;
	private final int REGISTRATIONS_OTHER_LIST_ID = 5;
	private final int REGISTRATIONS_EDITED_LIST_ID = 1;
	
	
	
	/**
	 * @return the regData
	 */
	public List<RegistrationData> getRegData() {
		List<RegistrationData> regData = TableDAO.getRegistrationTableValues(REGISTRATION_LIST_ID);
		return regData;
	}
	
	public List<RegistrationData> getWaitData() {
		List<RegistrationData> regData = TableDAO.getRegistrationTableValues(WAITING_LIST_ID);
		return regData;
	}
	
	public List<RegistrationData> getRegEditedData() {
		List<RegistrationData> regData = TableDAO.getRegistrationTableValues(REGISTRATIONS_EDITED_LIST_ID);
		return regData;
	}
	
	public List<RegistrationData> getRegOtherData() {
		List<RegistrationData> regData = TableDAO.getRegistrationTableValues(REGISTRATIONS_OTHER_LIST_ID);
		return regData;
	}
	
	public void getCustomerData(String strId){
		customerData = TableDAO.getCustomerData(Integer.parseInt(strId));
	}

	/**
	 * @return the customerData
	 */
	public RegistrationData getCustomerData() {
		return customerData;
	}

	/**
	 * @param customerData the customerData to set
	 */
	public void setCustomerData(RegistrationData customerData) {
		this.customerData = customerData;
	}
}
