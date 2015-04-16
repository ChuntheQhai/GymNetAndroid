package com.tiki.gymnet.models;

public class Message {
	
	int userImage;
	String time;
	String message;
	
	public Message(int userImage,
			String time, 
			String message)
	{
		this.userImage= userImage;
		this.time = time;
		this.message = message;
	}
	
	public int getUserImage() {
		return userImage;
	}

	public void setUserImage(int userImage) {
		this.userImage = userImage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessages() {
		return message;
	}

	public void setMessages(String message) {
		this.message = message;
	}

	
	

	
}
