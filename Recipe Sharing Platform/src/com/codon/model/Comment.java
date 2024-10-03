package com.codon.model;

public class Comment {
	private int Comment_ID;
	private int Recipe_ID;
	private String User_Name;
	private String Comment;
	public Comment() {
		super();
	}
	public Comment(int comment_ID, int recipe_ID, String user_Name, String comment) {
		super();
		Comment_ID = comment_ID;
		Recipe_ID = recipe_ID;
		User_Name = user_Name;
		Comment = comment;
	}
	
	public Comment(String user_Name, String comment) {
		super();
		User_Name = user_Name;
		Comment = comment;
	}
	
	public int getComment_ID() {
		return Comment_ID;
	}
	public void setComment_ID(int comment_ID) {
		Comment_ID = comment_ID;
	}
	public int getRecipe_ID() {
		return Recipe_ID;
	}
	public void setRecipe_ID(int recipe_ID) {
		Recipe_ID = recipe_ID;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	
	@Override
	public String toString() {
		return "Comment [Comment_ID=" + Comment_ID + ", Recipe_ID=" + Recipe_ID + ", User_Name=" + User_Name
				+ ", Comment=" + Comment + "]";
	}
}
