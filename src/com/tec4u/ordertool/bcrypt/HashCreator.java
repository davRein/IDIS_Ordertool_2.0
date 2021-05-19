package com.tec4u.ordertool.bcrypt;

public class HashCreator 
{
	public static String getHash(String strPassword, String strSalt) {
		String strHash = BCrypt.hashpw(strPassword, strSalt);
		return strHash;
	}
}
