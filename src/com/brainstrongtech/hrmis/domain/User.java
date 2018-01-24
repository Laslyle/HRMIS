/**
 * 
 */
package com.brainstrongtech.hrmis.domain;

/**
 * 
 * ²Ù×÷Ô±Àà
 * @author joeyang ong
 *
 */
public class User extends ValueObject{
	private String userName;

	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}



	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String toString(){

		return userName+":"+passWord;
}
}
