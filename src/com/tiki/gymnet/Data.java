package com.tiki.gymnet;

import java.util.ArrayList;

import com.tiki.gymnet.models.Comment;

public class Data {
	
	public static int userImage;
	public static String userName;
	public static String time;
	public static String message;
	public static String comment;
	public static String location;
	public static String workout;
	public static ArrayList<Comment> commentList;
	
	public Data(int userImage, 
			String userName,
			String message,
			String time,
			String comment,
			String location,
			String workout,
			ArrayList<Comment> commentList)
	{
		this.userImage = userImage;
		this.userName = userName;
		this.message = message;
		this.time = time;
		this.comment = comment;
		this.location= location;
		this.workout = workout;
		this.commentList = commentList;
	
	}
	
	
	
	
}
