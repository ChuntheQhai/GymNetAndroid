package com.tiki.gymnet.models;

import java.util.ArrayList;

import com.tiki.gymnet.R;

public class Feed {

	int userImage;
	String time;
	String userName;
	String location;
	String message;
	String workout;
	int like;
	ArrayList<Comment> commentList;
	boolean isOTW;
	
	public Feed(int userImage, 
			String time, 
			String userName, 
			String location,
			String message, 
			String workout, 
			int like, 
			ArrayList<Comment> commentList,
			boolean isOTW)
	{ 
		this.userImage = userImage;
		this.time = time;
		this.userName = userName;
		this.location = location;
		this.message = message;
		this.workout = workout;
		this.like = like;
		this.commentList = commentList;
		this.isOTW = isOTW;
		
		if (commentList == null)
			this.commentList = new ArrayList<Comment>();
	}
	
	
	public boolean isOTW() {
		return isOTW;
	}


	public void setOTW(boolean isOTW) {
		this.isOTW = isOTW;
	}


	public String getLocation() {
		return "Fitness First Paradigm";//location;
	}


	public void setLocation(String location) {
		this.location = location;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getWorkout() {
		return workout;
	}
	public void setWorkout(String workout) {
		this.workout = workout;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public ArrayList<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}
}
