package com.tweetapp.dto;

public class NewPassword {
	private String newPassword;
	private String contact;

	public NewPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewPassword(String newPassword, String contact) {
		super();
		this.newPassword = newPassword;
		this.contact = contact;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
