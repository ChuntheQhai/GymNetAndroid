package com.tiki.gymnet.models;

import java.util.ArrayList;

public class FVenue {

	String name;
	FLocation location;
	ArrayList<FCategory> categories;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FLocation getLocation() {
		return location;
	}
	public void setLocation(FLocation location) {
		this.location = location;
	}
	public ArrayList<FCategory> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<FCategory> categories) {
		this.categories = categories;
	}
	
	@Override
	public String toString()
	{
		return "[name = "+name+"]";
	}
}
