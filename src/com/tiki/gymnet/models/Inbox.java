package com.tiki.gymnet.models;

public class Inbox {
	
	int userImage;
	String userName;
	String time;
	String message;
	
	public Inbox(int userImage,
			String userName,
			String time,
			String message)
	{
		this.userImage = userImage;
		this.userName = userName;
		this.time = time;
		this.message = message;
	}
	
	public int getUserImage() {
		return userImage;
	}
	public void setUserImage(int userImage) {
		this.userImage = userImage;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
