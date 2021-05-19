/**
 * 
 */
package com.tec4u.ordertool.settings;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author d.reinerts
 *
 */
@Named("config")
@RequestScoped
public class Config implements Serializable {

	private static final long serialVersionUID = -240922514807517429L;

	private String strHost = "82.165.185.245";

	private String strAssets;

	public Config() {
		strAssets = "//" + strHost + "/limitless/assets";
	}

	/**
	 * @return the strAssets
	 */
	public String getStrAssets() {
		return strAssets;
	}
}
